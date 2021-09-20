package com.api.endereco.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.endereco.model.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {

}