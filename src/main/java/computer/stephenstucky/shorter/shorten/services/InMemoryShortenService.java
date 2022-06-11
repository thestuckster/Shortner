package computer.stephenstucky.shorter.shorten.services;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

import static computer.stephenstucky.shorter.shorten.services.ServiceConstants.ID_LENGTH;

@Repository
public class InMemoryShortenService implements IShortenService {

    private static final HashMap<String, String> SHORTENED_URLS = new HashMap<>();
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public String shortenUrl(String url) {
        final String key = RandomStringUtils.randomAlphanumeric(ID_LENGTH);
        SHORTENED_URLS.put(key, url);

        logger.info("saving url [{}] with short id [{}]", url, key);

        return key;
    }

    @Override
    public String lengthenUrl(String id) {
        return SHORTENED_URLS.getOrDefault(id, StringUtils.EMPTY);
    }
}
