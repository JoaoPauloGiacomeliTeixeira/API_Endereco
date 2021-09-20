package com.api.endereco;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.api.endereco.model.Endereco;
import com.api.endereco.service.EnderecoService;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class EnderecoControllerTest {

	@Autowired
	MockMvc mockMvc;
	
	@MockBean
	private EnderecoService enderecoService;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	@Test
	public void enderecoTestGetAll() throws Exception {
		mockMvc.perform(get("/endereco/getAll"))
			.andExpect(status().isOk());
	}
	
	@Test
	public void enderecoTestInsertEndereco() throws Exception {
		Endereco endereco = new Endereco();
		
		endereco.setStreetName("Rua Antonio Dias da Silva");
		endereco.setNumber(231);
		endereco.setNeighbourhood("Vila Amalia");
		endereco.setCity("São Paulo");
		endereco.setState("São Paulo");
		endereco.setCountry("Brasil");
		endereco.setZipcode("02618080");
		endereco.setComplement("");
		endereco.setLatitude(null);
		endereco.setLongitude(null);		
		
		mockMvc.perform(post("/endereco/insert")
			.contentType("application/json")
			.content(objectMapper.writeValueAsString(endereco)))
			.andExpect(status().isOk());
	}
	
	@Test
	public void enderecoTestUpdateEndereco() throws Exception {
		Endereco endereco = new Endereco();
		
		endereco.setStreetName("Rua Antonio Dias da Silva");
		endereco.setNumber(231);
		endereco.setNeighbourhood("Vila Amalia");
		endereco.setCity("São Paulo");
		endereco.setState("São Paulo");
		endereco.setCountry("Brasil");
		endereco.setZipcode("02618080");
		endereco.setComplement("");
		endereco.setLatitude(null);
		endereco.setLongitude(null);
		
		when(this.enderecoService.updateEndereco(endereco))
			.thenReturn(endereco);
		
		mockMvc.perform(put("/endereco/update/{id}", 1)
			.contentType("application/json")
			.content(objectMapper.writeValueAsString(endereco)))
			.andExpect(status().isOk());
	}
	
	@Test
	public void enderecoTestDeleteEndereco() throws Exception {
		 mockMvc.perform(delete("/endereco/insert/{id}", 1))
			.andExpect(status().isNotFound());
	}
	
}
