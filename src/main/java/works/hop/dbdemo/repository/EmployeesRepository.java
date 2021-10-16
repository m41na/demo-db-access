package works.hop.dbdemo.repository;

import org.springframework.data.repository.CrudRepository;
import works.hop.dbdemo.entity.Employee;

public interface EmployeesRepository extends CrudRepository<Employee, Long> {

}
