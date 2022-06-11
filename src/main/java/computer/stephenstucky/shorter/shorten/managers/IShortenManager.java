package computer.stephenstucky.shorter.shorten.managers;

import computer.stephenstucky.shorter.shorten.models.ShortenRequest;
import computer.stephenstucky.shorter.shorten.models.ShortenResponse;

public interface IShortenManager {

    ShortenResponse shortenUrl(ShortenRequest request);

}
