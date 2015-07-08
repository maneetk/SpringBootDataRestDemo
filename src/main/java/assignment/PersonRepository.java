package assignment;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
//import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//@RepositoryRestResource(collectionResourceRel = "people", path = "people")
public interface PersonRepository extends CrudRepository<Person, Long> {
	Person findByFirstName(@Param("name") String firstName);
}
