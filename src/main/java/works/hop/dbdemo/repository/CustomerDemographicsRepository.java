package works.hop.dbdemo.repository;

import org.springframework.data.repository.CrudRepository;
import works.hop.dbdemo.entity.CustomerDemographic;

public interface CustomerDemographicsRepository extends CrudRepository<CustomerDemographic, String> {

}
