package ari.nuryadi.testingbackend.entity.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "detail_challenge")
@Data
public class DetailChallenge {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "detail_challenge_id_seq")
    @SequenceGenerator(name = "detail_challenge_id_seq", sequenceName = "detail_challenge_id_seq")
    private Long id;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "challenger_id")
    private Long challengerId;

    private String kriteria;

    private Integer status;
}
