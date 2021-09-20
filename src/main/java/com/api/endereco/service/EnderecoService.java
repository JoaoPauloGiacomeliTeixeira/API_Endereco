package com.api.endereco.service;

import java.util.List;

import com.api.endereco.model.Endereco;

public interface EnderecoService {
	
	List<Endereco> getAllEndereco();
	
	Endereco getEnderecoById(long id);
	
	Endereco insertEndereco(Endereco endereco);
	
	Endereco updateEndereco(Endereco endereco);
	
	Endereco deleteEndereco(long id);

}