package works.hop.db.access.repository;

import org.springframework.data.repository.CrudRepository;

import works.hop.db.access.entity.Demographic;

public interface DemographicsRepository extends CrudRepository<Demographic, String>{

}
