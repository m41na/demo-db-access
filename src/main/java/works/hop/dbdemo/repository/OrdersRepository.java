package works.hop.dbdemo.repository;

import org.springframework.data.repository.CrudRepository;
import works.hop.dbdemo.entity.Order;

public interface OrdersRepository extends CrudRepository<Order, Long> {

}
