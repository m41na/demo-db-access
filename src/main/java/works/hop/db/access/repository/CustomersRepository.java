package works.hop.db.access.repository;

import org.springframework.data.repository.CrudRepository;

import works.hop.db.access.entity.Customer;

public interface CustomersRepository extends CrudRepository<Customer, String>{

}
