package ari.nuryadi.testingbackend.utils.response;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class ErrorResponse extends AbstractResponse {

    private List<String> details;

    public ErrorResponse(int status, String message,  List<String> details) {
        this.setCode(status);
        this.setMessage(message);
        this.details = details;
    }
}
