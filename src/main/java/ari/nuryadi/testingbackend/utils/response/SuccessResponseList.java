package ari.nuryadi.testingbackend.utils.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SuccessResponseList extends AbstractResponse {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("data")
    private List details;
}
