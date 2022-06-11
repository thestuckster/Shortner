package computer.stephenstucky.shorter.exceptions;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;

@ControllerAdvice
public class ExceptionHandler extends ResponseEntityExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(value = ApiException.class)
    protected ResponseEntity<Object> handleException(ApiException e, WebRequest request) throws JsonProcessingException {

        final var body = new HashMap<String, Object>();
        body.put("message", e.getMessage());
        body.put("errors", e.getErrors());

        final var jsonBody = new ObjectMapper().writeValueAsString(body);

        return new ResponseEntity<>(jsonBody, e.getStatus());

    }

}
