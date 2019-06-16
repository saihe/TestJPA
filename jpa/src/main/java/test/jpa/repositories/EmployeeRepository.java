package test.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import test.jpa.entities.Employee;

/**
 * 従業員repository
 */
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
