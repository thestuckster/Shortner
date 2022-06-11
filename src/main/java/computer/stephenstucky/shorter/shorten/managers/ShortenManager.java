package computer.stephenstucky.shorter.shorten.managers;

import computer.stephenstucky.shorter.shorten.models.ShortenRequest;
import computer.stephenstucky.shorter.shorten.models.ShortenResponse;
import computer.stephenstucky.shorter.shorten.services.IShortenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class ShortenManager implements IShortenManager {

    private final IShortenService service;

    @Autowired
    public ShortenManager(@Qualifier("dynamoService") IShortenService service) {

        this.service = service;
    }

    @Override
    public ShortenResponse shortenUrl(ShortenRequest request) {

        final var shortId = service.shortenUrl(request.getUrl());
        return new ShortenResponse(shortId);
    }
}
