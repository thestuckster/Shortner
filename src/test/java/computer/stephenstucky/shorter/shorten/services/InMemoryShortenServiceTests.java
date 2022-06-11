package computer.stephenstucky.shorter.shorten.services;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class InMemoryShortenServiceTests {

    @Test
    public void ShouldShortenUrl() {
        final InMemoryShortenService service = new InMemoryShortenService();
        final String shortId = service.shortenUrl("test");

        assertThat(shortId).isNotEmpty();
    }

    @Test
    public void ShouldReturnEmptyString() {
        final InMemoryShortenService service = new InMemoryShortenService();
        final String longUrl = service.lengthenUrl("fakerfakefake");

        assertThat(longUrl).isEqualTo(StringUtils.EMPTY);
    }

    @Test
    public void ShouldReturnLongUrl() {
        final String url = "test";

        final InMemoryShortenService service = new InMemoryShortenService();
        final String shortId = service.shortenUrl(url);

        final String longUrl = service.lengthenUrl(shortId);

        assertThat(longUrl).isEqualTo(url);
    }

}
