package test.jpa.entities;

import lombok.Data;

import javax.persistence.*;

/**
 * 所属entity
 */
@Data
@Entity
@Table(name = "division")
public class Division {
    /** ID. */
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    /** 所属名. */
    @Column(name = "division_name")
    private String deivisionName;
}
