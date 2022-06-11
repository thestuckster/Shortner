package computer.stephenstucky.shorter;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class HealthController {


    @GetMapping(value = "/health")
    public HashMap<String,String> healthCheck() {
        final var response = new HashMap<String, String>();
        response.put("data", "punks not deat and neither am I!");

        return response;
    }

}
