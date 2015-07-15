package assignment;

import java.util.List;

public interface PersonService {
	
	public Person savePerson(Person person);
	
	public List<Person> findPersonByFirstName(String firstName);
	
	public Person findRandom();
}
