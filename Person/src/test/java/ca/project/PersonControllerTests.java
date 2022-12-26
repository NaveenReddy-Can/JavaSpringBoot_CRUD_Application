package ca.project;

import static org.mockito.ArgumentMatchers.eq;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(PersonController.class)
class PersonControllerTests {
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private PersonRepository personRepo;

	// Test method to check createperson link is working or not
	@Test
	public void createpersonTest() throws Exception {
		mockMvc.perform(get("/createperson"))
				// .andDo(print());
				.andExpect(status().isOk()).andExpect(view().name("personform"))
				.andExpect(model().attribute("person", new Person()));
	}

	// Test method to check createperson link is working and person is saved or not.
	@Test
	public void createPostTest() throws Exception {
		Person expectedPerson = new Person(null, "Naveen", "male", "email@gmail");
		mockMvc.perform(
				post("/createperson").param("name", "Naveen").param("gender", "male").param("email", "email@gmail"))

				.andExpect(status().isOk()).andExpect(view().name("saved"))
				.andExpect(model().attribute("person", expectedPerson));

		Mockito.verify(personRepo).save(eq(expectedPerson));
	}

	// Test method to check createperson link is working and invalid data is passed.
	@Test
	public void createPostTest_InvalidPerson() throws Exception {
		Person expectedPerson = new Person(null, "", "male", "email@gmail");
		mockMvc.perform(post("/createperson").param("name", "").param("gender", "male").param("email", "email@gmail"))

				.andExpect(status().isOk()).andExpect(view().name("personform"))
				.andExpect(model().attribute("person", expectedPerson));

		Mockito.verifyNoInteractions(personRepo);
	}
//------------------------------------------------------------------------------------------------------------------------------------------------------------
	// Test method to check allpersons in list.
	@Test
	public void listAllPersonsTest() throws Exception {

		List<Person> AllPersons = personRepo.findAll();

		mockMvc.perform(get("/allpersons")).andExpect(status().isOk()).andExpect(view().name("listpersons"))
				.andExpect(model().attribute("persons", AllPersons));

		List<Person> expectedPerson = new ArrayList<Person>();

		expectedPerson = personRepo.findAll().stream()
				.filter(persons -> (persons.getName().toLowerCase().contains(Mockito.eq("Naveen"))))
				.collect(Collectors.toList());
		Mockito.when(personRepo.findAll().stream()
				.filter(persons -> (persons.getName().toLowerCase().contains(Mockito.eq("Naveen"))))
				.collect(Collectors.toList())).thenReturn(expectedPerson);

		mockMvc.perform(get("/allpersons?find=naveen")).andExpect(status().isOk()).andExpect(view().name("listpersons"))
				.andExpect(model().attribute("persons", expectedPerson));
	}

	@Test
	//test case to check the index page is working or not.
	public void indexTest() throws Exception {
		mockMvc.perform(get("/"))
				// .andDo(print());
				.andExpect(status().isOk()).andExpect(view().name("index"));
	}

}
