package computer.stephenstucky.shorter.shorten.services;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;
import software.amazon.awssdk.enhanced.dynamodb.Key;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;

@Repository
@Qualifier("dynamoService")
public class DynamoDbShortenService implements IShortenService {

    private static final DynamoDbClient dynamo = DynamoDbClient.builder().build();
    private static final DynamoDbEnhancedClient dynamoV2 = DynamoDbEnhancedClient.builder()
                                                                                 .dynamoDbClient(dynamo)
                                                                                 .build();

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final DynamoDbTable<UrlDto> table;

    public DynamoDbShortenService() {

        logger.info("connecting to dynamo..." );
        table = dynamoV2.table(ServiceConstants.TABLE_NAME, TableSchema.fromBean(UrlDto.class));
        logger.info("connected!");
    }

    @Override
    public String shortenUrl(String url) {

        final var shortId = generateId();

        logger.info("Saving url [{}] under shortId [{}]", url, shortId);
        final var dto = new UrlDto(shortId, url);
        try {
            table.putItem(dto);
        } catch (Exception e) {
            logger.error("Unable to save to dymamo\n", e);
            return StringUtils.EMPTY;
        }

        return shortId;
    }

    @Override
    public String lengthenUrl(String id) {

        try {
            final var longUrlDto = table.getItem(Key.builder().partitionValue(id).build());
            if (longUrlDto == null) {
                logger.warn("Unable to find long url with id [{}]. returning empty string instead.", id);
                return StringUtils.EMPTY;
            }

            return longUrlDto.getUrl();
        } catch (Exception e) {
            logger.error("Something went wrong when trying to lookup long url", e);
        }

        return StringUtils.EMPTY;
    }

    private String generateId() {

        return RandomStringUtils.randomAlphanumeric(ServiceConstants.ID_LENGTH);
    }
}
