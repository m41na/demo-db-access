package works.hop.dbdemo.repository;


import org.springframework.data.repository.CrudRepository;
import works.hop.dbdemo.entity.Product;

public interface ProductsRepository extends CrudRepository<Product, Long> {

}
