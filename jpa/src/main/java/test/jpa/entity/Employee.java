package test.jpa.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * 従業員エンティティ
 */
@Entity
@Data
public class Employee {
    /** ID. */
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;
    /** 社員コード. */
    @Column(name = "employee_code")
    private String employeeCode;
    /** 社員名. */
    @Column(name = "employee_name")
    private String employeeName;
    /** 所属ID. */
    @Column(name = "division_id")
    private Integer divisionId;
}
