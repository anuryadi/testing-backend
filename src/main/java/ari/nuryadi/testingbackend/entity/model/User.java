package ari.nuryadi.testingbackend.entity.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Users")
@Data
public class User {
    @Id
    private Long id;

    private String name;

    private String email;

    private String password;

    private String phone;

    private Integer poin;

    private Integer rangking;

    @OneToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(name = "detail_challenge",
            joinColumns = { @JoinColumn(name = "user_id") },
            inverseJoinColumns = { @JoinColumn(name = "challenger_id") })
    private List<Challenge> challenges;
}
