package computer.stephenstucky.shorter.shorten.managers;

import computer.stephenstucky.shorter.shorten.managers.ShortenManager;
import computer.stephenstucky.shorter.shorten.models.ShortenRequest;
import computer.stephenstucky.shorter.shorten.models.ShortenResponse;
import computer.stephenstucky.shorter.shorten.services.IShortenService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

public class ShortenManagerTests {

    private static final String SHORT_ID = "abc123";

    @Mock
    private IShortenService mockService;

    @InjectMocks
    private ShortenManager manager;

    @BeforeEach
    public void Setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void ShouldShortenUrl() {
        when(mockService.shortenUrl(anyString())).thenReturn(SHORT_ID);

        final var request = new ShortenRequest();
        request.setUrl("http://google.com");
        final var response = manager.shortenUrl(request);

        assertThat(response).isNotNull();
        assertThat(response.getShortId()).isEqualTo(SHORT_ID);
    }

}
