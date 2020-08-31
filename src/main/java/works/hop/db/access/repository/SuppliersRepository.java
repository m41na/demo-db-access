package works.hop.db.access.repository;


import org.springframework.data.repository.CrudRepository;
import works.hop.db.access.entity.Supplier;

public interface SuppliersRepository extends CrudRepository<Supplier, Long> {

}
