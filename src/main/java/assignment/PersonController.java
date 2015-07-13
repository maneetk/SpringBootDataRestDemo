package assignment;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class PersonController {
	
	private PersonService service;
	
	@Autowired
	PersonController(PersonService service) {
		this.service = service;
	}
	
	PersonController() {
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public Person savePerson(@RequestBody Person person){
		return service.savePerson(person);
	}
	
	@RequestMapping(value="{name}", method=RequestMethod.GET)
	public List<Person> findPersonByFirstName(@PathVariable("name") String firstName){
		return service.findPersonByFirstName(firstName);
	}
}
