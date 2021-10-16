package works.hop.dbdemo.repository;

import org.springframework.data.repository.CrudRepository;
import works.hop.dbdemo.entity.Customer;

public interface CustomersRepository extends CrudRepository<Customer, String> {

}
