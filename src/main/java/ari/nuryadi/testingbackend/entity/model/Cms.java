package ari.nuryadi.testingbackend.entity.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "cms")
@Data
public class Cms {
    @Id
    private Long id;

    private String judul;

    private String deskripsi;

    private Date tanggal;

    @ApiModelProperty(dataType = "integer", allowableValues = "1, 0", value = "description", notes = "notes")
    private Integer status;

    @JsonProperty("kata_kunci")
    private String kataKunci;

    private Integer type;
}
