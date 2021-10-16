package works.hop.dbdemo.repository;

import org.springframework.data.repository.CrudRepository;
import works.hop.dbdemo.entity.Shipper;

public interface ShippersRepository extends CrudRepository<Shipper, Long> {

}
