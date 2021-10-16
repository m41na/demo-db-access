package works.hop.dbdemo.repository;

import org.springframework.data.repository.CrudRepository;
import works.hop.dbdemo.entity.Territory;

public interface TerritoriesRepository extends CrudRepository<Territory, Long> {

}
