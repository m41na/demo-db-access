package works.hop.db.access.repository;

import org.springframework.data.repository.CrudRepository;

import works.hop.db.access.entity.CustomerDemographic;

public interface CustomerDemographicsRepository extends CrudRepository<CustomerDemographic, String>{

}
