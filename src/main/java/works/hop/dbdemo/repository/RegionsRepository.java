package works.hop.dbdemo.repository;

import org.springframework.data.repository.CrudRepository;
import works.hop.dbdemo.entity.Region;

public interface RegionsRepository extends CrudRepository<Region, String> {

}
