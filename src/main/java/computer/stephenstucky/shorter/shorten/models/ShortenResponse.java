package computer.stephenstucky.shorter.shorten.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
@AllArgsConstructor
public class ShortenResponse implements Serializable {

    @Serial
    private static final long serialVersionUID = 6154331946190575322L;

    private String shortId;
}
