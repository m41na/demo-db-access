package works.hop.dbdemo.repository;

import org.springframework.data.repository.CrudRepository;
import works.hop.dbdemo.entity.Demographic;

public interface DemographicsRepository extends CrudRepository<Demographic, String> {

}
