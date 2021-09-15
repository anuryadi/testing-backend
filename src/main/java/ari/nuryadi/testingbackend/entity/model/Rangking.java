package ari.nuryadi.testingbackend.entity.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Users")
@Data
public class Rangking {
    @Id
    private Long id;

    private String name;

    private String email;

    private String phone;

    private Integer poin;

    private Integer rangking;
}
