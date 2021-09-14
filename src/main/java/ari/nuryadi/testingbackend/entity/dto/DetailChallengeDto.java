package ari.nuryadi.testingbackend.entity.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DetailChallengeDto {
    private Long id;

    @JsonProperty("user_id")
    private Long userId;

    @JsonProperty("challenger_id")
    private Long challengerId;

    @JsonProperty("kriteria")
    private String kriteria;

    private Integer status;
}
