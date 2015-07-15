package assignment;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

@Controller
@RequestMapping
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
	
	
	
	@RequestMapping(value="{name}", method=RequestMethod.GET, produces={MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE})
	public @ResponseBody List<Person> findPersonByFirstName(@PathVariable("name") String firstName){
		List<Person> personList = service.findPersonByFirstName(firstName);
		System.out.println("size: " + personList.size());
		return service.findPersonByFirstName(firstName);
	}
	
	@RequestMapping(value="/html/{name}", method=RequestMethod.GET)
	public String findPersonAndReturnView(@PathVariable("name") String firstName, Model model){
		model.addAttribute("personList", findPersonByFirstName(firstName));
		return "person";
	}
	
	@RequestMapping(value="/jsonView/{name}", method=RequestMethod.GET)
	public ModelAndView findPersonAndReturnJsonView(@PathVariable("name") String firstName){
		ModelAndView model = new ModelAndView(new MappingJackson2JsonView());
		model.addObject("personList", findPersonByFirstName(firstName));
		return model;
	}
	
}
