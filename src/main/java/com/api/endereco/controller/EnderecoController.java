package com.api.endereco.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.endereco.model.Endereco;
import com.api.endereco.service.EnderecoService;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {

	@Autowired
	private EnderecoService enderecoService;
	
	@GetMapping("/getAll")
	public ResponseEntity<List<Endereco>> getAllendereco() {		
		return ResponseEntity.ok().body(this.enderecoService.getAllEndereco());
	}
	
	@GetMapping("/getById/{id}")
	public ResponseEntity<Endereco> getEnderecoById(@PathVariable long id) {
		return ResponseEntity.ok().body(this.enderecoService.getEnderecoById(id));
	}
	
	@PostMapping("/insert")	
	public ResponseEntity<Endereco> insertEndereco(@RequestBody Endereco endereco) {
		return ResponseEntity.ok().body(this.enderecoService.insertEndereco(endereco));
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Endereco> updateEndereco(@PathVariable long id, @RequestBody Endereco endereco) {
		endereco.setId(id);
		return ResponseEntity.ok().body(this.enderecoService.updateEndereco(endereco));
	}
		
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Endereco> deleteEndereco(@PathVariable long id) {		
		return ResponseEntity.ok().body(this.enderecoService.deleteEndereco(id));
	}
	
}
