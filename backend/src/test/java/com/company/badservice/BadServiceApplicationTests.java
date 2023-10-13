package com.company.badservice;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


import com.company.badservice.dto.ElephantRequest;
import com.company.badservice.dto.TigerRequest;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
class BadServiceApplicationTests {

	@Autowired
	private MockMvc mockMvc;
	@Autowired
	// From POJO to JSON and vice verse
	private ObjectMapper objectMapper;


	// ----- Tiger tests -----

	@Test
	void shouldCreateTiger() throws Exception{

		TigerRequest tigerRequest2 = new TigerRequest(2L,"Mister Tiger");
		TigerRequest tigerRequest3 = new TigerRequest(3L, "Tray Tiger");

		String tigerRequestString = objectMapper.writeValueAsString(tigerRequest2);
		String tigerRequestString2 = objectMapper.writeValueAsString(tigerRequest3);

		mockMvc.perform(MockMvcRequestBuilders.post("/create-tiger")
												.contentType(MediaType.APPLICATION_JSON)
												.accept(MediaType.APPLICATION_JSON)
												.content(tigerRequestString))
												.andExpect(status().isCreated());

		mockMvc.perform(MockMvcRequestBuilders.post("/create-tiger")
												.contentType(MediaType.APPLICATION_JSON)
												.accept(MediaType.APPLICATION_JSON)
												.content(tigerRequestString2))
												.andExpect(status().isCreated());
	}

	@Test
	void shouldOutputTigersList() throws Exception{

		mockMvc.perform(MockMvcRequestBuilders.get("/tigers")
												.contentType(MediaType.APPLICATION_JSON)
												.accept(MediaType.APPLICATION_JSON))
												.andExpect(status().isOk());

		
	}

	@Test
	void shouldSearchTiger() throws Exception{

		mockMvc.perform(MockMvcRequestBuilders.get("/search-tiger")
												.contentType(MediaType.APPLICATION_JSON)
												.accept(MediaType.APPLICATION_JSON)
												.param("id", "1"))
												.andExpect(status().isOk());	
		
	}

	@Test
	void shouldUpdateTiger() throws Exception{
		TigerRequest tigerRequest = updateTigerRequest();
		String tigerRequestString = objectMapper.writeValueAsString(tigerRequest);

		mockMvc.perform(MockMvcRequestBuilders.put("/update-tiger")
												.contentType(MediaType.APPLICATION_JSON)
												.accept(MediaType.APPLICATION_JSON)
												.content(tigerRequestString))
												.andExpect(status().isOk());		
	}

	private TigerRequest updateTigerRequest() {
		return TigerRequest.builder()
							.id(1L)
							.name("Duke Norton")
							.build();
	}


	

	@Test 
	void shouldDeleteTiger() throws Exception{

		mockMvc.perform(MockMvcRequestBuilders.delete("/delete-tiger", 1)
												.contentType(MediaType.APPLICATION_JSON)
												.accept(MediaType.APPLICATION_JSON)
												.param("id", "1"))
												.andExpect(status().isOk());
	}


	// ----- Elephant tests -----

	@Test
	void shouldCreareElephant() throws Exception{
		ElephantRequest elephantRequest = getElephantRequest();
		String elephantRequestString = objectMapper.writeValueAsString(elephantRequest);

		mockMvc.perform(MockMvcRequestBuilders.post("/create-elephant")
												.contentType(MediaType.APPLICATION_JSON)
												.content(elephantRequestString))
												.andExpect(status().isCreated());
	}

	private ElephantRequest getElephantRequest() {
		return ElephantRequest.builder()
								.id(1L)
								.name("Dumbo Liffy")
								.elephantAge(2)
								.build();
	}

	@Test
	void shouldOutputElephantsList() throws Exception{
		mockMvc.perform(MockMvcRequestBuilders.get("/elephants")
												.contentType(MediaType.APPLICATION_JSON)
												.accept(MediaType.APPLICATION_JSON))
												.andExpect(status().isOk());
	}

}
