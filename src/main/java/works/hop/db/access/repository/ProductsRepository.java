package works.hop.db.access.repository;


import org.springframework.data.repository.CrudRepository;

import works.hop.db.access.entity.Product;

public interface ProductsRepository extends CrudRepository<Product, Long>{

}
