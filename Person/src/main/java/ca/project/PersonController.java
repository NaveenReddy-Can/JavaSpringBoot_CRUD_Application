package ca.project;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PersonController {

	@Autowired
	private PersonRepository personRepo;

	@GetMapping("/createperson")
	public String personForm(Model model) {
		model.addAttribute("person", new Person());
		return "personform";
	}

	@PostMapping("/createperson")
	public String createPerson(@Valid Person toSave, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "personform";
		} else {
			this.personRepo.save(toSave);
			return "saved";
		}
	}

	@GetMapping("/allpersons")
	public String listAllPersons(Model model, @RequestParam(required = false) String find) {

		List<Person> listPerson = personRepo.findAll().stream()
				.filter(find != null && !find.isEmpty()
						? persons -> (persons.getName().toLowerCase().contains(find.toLowerCase())
								|| persons.getGender().toLowerCase().contains(find.toLowerCase())
								|| persons.getEmail().toLowerCase().contains(find.toLowerCase()))
						: persons -> true)
				.collect(Collectors.toList());
		model.addAttribute("persons", listPerson);

		return "listpersons";
	}

}
