package computer.stephenstucky.shorter.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Arrays;
import java.util.Collections;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundException extends ApiException {

    public NotFoundException(String error) {
        super(HttpStatus.NOT_FOUND, "NOT_FOUND", Collections.singletonList(error));
    }

}
