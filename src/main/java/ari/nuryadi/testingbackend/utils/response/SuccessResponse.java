package ari.nuryadi.testingbackend.utils.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SuccessResponse extends AbstractResponse {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Object data;
}
