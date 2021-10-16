package works.hop.dbdemo.repository;


import org.springframework.data.repository.CrudRepository;
import works.hop.dbdemo.entity.Supplier;

public interface SuppliersRepository extends CrudRepository<Supplier, Long> {

}
