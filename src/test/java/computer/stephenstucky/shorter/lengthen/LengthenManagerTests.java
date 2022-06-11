package computer.stephenstucky.shorter.lengthen;

import computer.stephenstucky.shorter.lengthen.managers.LengthenManager;
import computer.stephenstucky.shorter.shorten.services.IShortenService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

public class LengthenManagerTests {

    @Mock
    private IShortenService mockService;

    @InjectMocks
    private LengthenManager manager;

    @BeforeEach
    public void SetupEach() {

        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void ShouldLengthenUrl() {

        final var expected = "http://stephenstucky.com";
        when(mockService.lengthenUrl(anyString())).thenReturn(expected);

        //holy shit. java has a var keyword now. the game has been changed.
        var longUrl = manager.lengthenUrl("abc123");
        assertThat(longUrl).isEqualTo(expected);
    }


}
