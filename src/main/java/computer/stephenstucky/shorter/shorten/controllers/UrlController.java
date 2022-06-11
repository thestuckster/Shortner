package computer.stephenstucky.shorter.shorten.controllers;

import computer.stephenstucky.shorter.lengthen.managers.ILengthenManager;
import computer.stephenstucky.shorter.shorten.managers.IShortenManager;
import computer.stephenstucky.shorter.shorten.models.ShortenRequest;
import computer.stephenstucky.shorter.shorten.models.ShortenResponse;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@RestController
public class UrlController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final IShortenManager shortenManager;
    private final ILengthenManager lengthenManager;

    @Autowired
    public UrlController(IShortenManager shortenManager, ILengthenManager lengthenManager) {
        this.shortenManager = shortenManager;
        this.lengthenManager = lengthenManager;
    }

    @PostMapping(value = "/shorten")
    public ShortenResponse shorten(@RequestBody ShortenRequest request) {

        return shortenManager.shortenUrl(request);
    }

    @GetMapping(value = "/lengthen/{id}")
    public Object lengthen(@PathVariable String id) {
        final var longUrl = lengthenManager.lengthenUrl(id);

        return new RedirectView(longUrl);
    }

}
