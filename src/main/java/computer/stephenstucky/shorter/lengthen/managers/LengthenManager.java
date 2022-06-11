package computer.stephenstucky.shorter.lengthen.managers;

import computer.stephenstucky.shorter.exceptions.NotFoundException;
import computer.stephenstucky.shorter.shorten.services.IShortenService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class LengthenManager implements ILengthenManager {

    private final IShortenService service;

    @Autowired
    public LengthenManager(@Qualifier("dynamoService") IShortenService service) {
        this.service = service;
    }

    @Override
    public String lengthenUrl(String shortId) {

        final var longUrl = service.lengthenUrl(shortId);

        if(StringUtils.isEmpty(longUrl)) {
            throw new NotFoundException("Unable to find url linked to id " + shortId);
        }

        return longUrl;
    }
}
