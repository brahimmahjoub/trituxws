package com.tritux.ws;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.tritux.ws.model.Candidate;
import com.tritux.ws.repository.CandidateRepository;
import com.tritux.ws.validation.exception.EmailExistsException;
import com.tritux.ws.web.CandidateController;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = TrituxWsApplication.class)
public class TrituxWsApplicationTests {

	final String BASE_URL = "http://localhost:8080/";
	private MockMvc mockMvc;
	@Autowired
	private CandidateRepository candidateService;

	@Before
	public void setup() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");
		this.mockMvc = standaloneSetup(new CandidateController())
				.setViewResolvers(viewResolver)
				.build();
	}

	@Test
	public void testWelcome() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders
				.get("/"))
				.andExpect(view().name("welcome"))
				.andExpect(forwardedUrl("/WEB-INF/views/welcome.jsp"))
				.andExpect(status().isOk());
	}
	
	@Test
	public void testCreate() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders
				.get("/create"))
				.andExpect(view().name("create"))
				.andExpect(forwardedUrl("/WEB-INF/views/create.jsp"))
				.andExpect(status().isOk());
	}
	
	@Test
	public void testSaveCandidate() throws Exception, EmailExistsException {
		
		Candidate candidateInstance = new Candidate();
		candidateInstance.setName("TrituxName");
		candidateInstance.setSurname("TrituxSurname");
		candidateInstance.setEmail("test@tritux.com");
		candidateInstance.setAge(25);
		
		//save candidate
		//check id before save
        assertNull(candidateInstance.getId()); //null before save
        candidateService.save(candidateInstance);
        assertNotNull(candidateInstance.getId()); //not null after save
		
	}

}
