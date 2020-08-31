package works.hop.db.access.repository;

import org.springframework.data.repository.CrudRepository;
import works.hop.db.access.entity.Category;

public interface CategoriesRepository extends CrudRepository<Category, Long> {

}
