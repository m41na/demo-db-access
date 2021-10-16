package works.hop.dbdemo.repository;

import org.springframework.data.repository.CrudRepository;
import works.hop.dbdemo.entity.Category;

public interface CategoriesRepository extends CrudRepository<Category, Long> {

}
