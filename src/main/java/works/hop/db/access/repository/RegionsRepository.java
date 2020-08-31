package works.hop.db.access.repository;

import org.springframework.data.repository.CrudRepository;
import works.hop.db.access.entity.Region;

public interface RegionsRepository extends CrudRepository<Region, String> {

}
