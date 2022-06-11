package computer.stephenstucky.shorter.shorten.models;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
public class ShortenRequest implements Serializable {

    @Serial
    private static final long serialVersionUID = 399355529022751651L;

    private String url;
}
