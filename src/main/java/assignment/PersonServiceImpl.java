package assignment;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements PersonService {
	
	private PersonRepository repository;
	
	@Autowired
	public PersonServiceImpl(PersonRepository repository) {
		this.repository = repository;
	}

	@Override
	public Person savePerson(Person person) {
		try{
			person = repository.save(person);
			System.out.println("Person saved at id: " + person.getId());
		}
		catch(Exception ex){
			System.out.println("Exception in savePerson of PersonServiceImpl.java" + ex);
			ex.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Person> findPersonByFirstName(String firstName) {
		try{
			List<Person> personList = repository.findByFirstName(firstName);
			return personList;
		}
		catch(Exception ex){
			System.out.println("Exception in findPersonByFirstName of PersonServiceImpl.java" + ex);
			ex.printStackTrace();
		}
		return null;
	}

}
