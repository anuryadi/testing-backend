package ari.nuryadi.testingbackend.entity.dto;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Users")
@Data
public class RangkingDto {
    @Id
    private Long id;

    private String name;

    private String email;

    private String phone;

    private Integer poin;

    private Integer rangking;
}
