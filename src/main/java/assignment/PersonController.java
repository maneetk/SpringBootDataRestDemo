package assignment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {
	
	@Autowired
	PersonRepository repository;

	@RequestMapping(value="/user", method=RequestMethod.POST)
	@ResponseBody
	public String savePerson(String firstName, String lastName){
		try{
			Person person = new Person();
			person.setFirstName(firstName);
			person.setLastName(lastName);
			repository.save(person);
			
			return "Person saved at id" + person.getId();
		}catch(Exception e){
			System.out.println("Exception in saving" + e);
			return "Could not save";
		}
	}
	
	@RequestMapping(value="/user/{firstName}", method=RequestMethod.GET)
	@ResponseBody
	public String getUserDetails(@PathVariable("firstName") String firstName) {
		try{
			Person person = new Person();
			person = repository.findByFirstName(firstName);
			System.out.println("id: " + person.getId());
			return "Person Id: " + person.getId() + " \nFirst name: " + person.getFirstName()
				+ "\n Last Name: " + person.getLastName();
		}catch(Exception e){
			System.out.println("Exception in getting" + e);
			return "Could not get the person with the specified name";
		}
	}
}
