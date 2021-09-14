package ari.nuryadi.testingbackend.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ChallengeDto {
    private Long id;

    private String judul;

    private String deskripsi;

    private Integer point;

    private String kriteria;
}
