package ari.nuryadi.testingbackend.entity.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CmsDto {

    private Long id;

    @NotNull(message = "First Name cannot be null")
    private String judul;

    @NotNull(message = "First Name cannot be null")
    private String deskripsi;

    private Integer status;

    @NotNull(message = "First Name cannot be null")
    @JsonProperty("kata_kunci")
    private String kataKunci;

    @NotNull(message = "First Name cannot be null")
    @Enumerated(EnumType.ORDINAL)
    private Integer type;
}
