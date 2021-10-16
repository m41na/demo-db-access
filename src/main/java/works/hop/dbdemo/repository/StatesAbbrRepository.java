package works.hop.dbdemo.repository;

import org.springframework.data.repository.CrudRepository;
import works.hop.dbdemo.entity.StatesAbbr;

public interface StatesAbbrRepository extends CrudRepository<StatesAbbr, Long> {

}
