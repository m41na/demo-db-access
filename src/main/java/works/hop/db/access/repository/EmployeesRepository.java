package works.hop.db.access.repository;

import org.springframework.data.repository.CrudRepository;

import works.hop.db.access.entity.Employee;

public interface EmployeesRepository extends CrudRepository<Employee, Long>{

}
