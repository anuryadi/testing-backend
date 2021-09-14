package ari.nuryadi.testingbackend.entity.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "challenge")
@Data
public class Challenge {
    @Id
    private Long id;

    private String judul;

    private String deskripsi;

    private Integer point;

    private String kriteria;

//    @JsonIgnore
//    @OneToMany(targetEntity = DetailChallenge.class, mappedBy = "challenge", fetch = FetchType.LAZY)
//    private List<DetailChallenge> detailChallengeList;

}
