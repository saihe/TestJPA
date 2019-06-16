package test.jpa.entities;

import lombok.Data;

import javax.persistence.*;

/**
 * 従業員entity
 */
@Data
@Entity
@Table(name = "employee")
public class Employee {
    /** ID. */
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    /** 社員コード. */
    @Column(name = "employee_code")
    private String employeeCode;
    /** 社員名. */
    @Column(name = "employee_name")
    private String employeeName;
//    /** 所属ID. */
//    @Column(name = "division_id")
//    private Integer divisionId;

    /** 所属リレーション. */
    @ManyToOne
    private Division division;

    @Override
    public String toString() {
        return "\"" + this.id
                + "\",\"" + this.employeeCode
                + "\",\"" + this.employeeName
                + "\",\"" + this.division.getDeivisionName()
                + "\"";
    }
}
