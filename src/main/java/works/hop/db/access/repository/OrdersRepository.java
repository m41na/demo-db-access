package works.hop.db.access.repository;

import org.springframework.data.repository.CrudRepository;
import works.hop.db.access.entity.Order;

public interface OrdersRepository extends CrudRepository<Order, Long> {

}
