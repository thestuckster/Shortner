package computer.stephenstucky.shorter.shorten.services;

import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

@DynamoDbBean
public class UrlDto implements Serializable {

    @Serial
    private static final long serialVersionUID = 5986983996491724617L;

    private String shortId;
    private String url;
    private LocalDateTime createdAt;
    private LocalDateTime ttl;

    public UrlDto() {

    }

    public UrlDto(String shortId, String url) {
        this(shortId, url, null);
    }

    public UrlDto(String shortId, String url, LocalDateTime ttl) {

        this.shortId = shortId;
        this.url = url;
        this.createdAt = LocalDateTime.now();
        this.ttl = ttl;
    }

    @DynamoDbPartitionKey
    public String getShortId() {

        return shortId;
    }

    public void setShortId(String shortId) {

        this.shortId = shortId;
    }

    public String getUrl() {

        return url;
    }

    public void setUrl(String url) {

        this.url = url;
    }

    public LocalDateTime getCreatedAt() {

        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {

        this.createdAt = createdAt;
    }

    public LocalDateTime getTtl() {

        return ttl;
    }

    public void setTtl(LocalDateTime ttl) {

        this.ttl = ttl;
    }
}
