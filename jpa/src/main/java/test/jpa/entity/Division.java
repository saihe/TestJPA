package test.jpa.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class Division {
    /** ID. */
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;
    /** 所属名. */
    @Column(name = "division_name")
    private String deivisionName;
}
