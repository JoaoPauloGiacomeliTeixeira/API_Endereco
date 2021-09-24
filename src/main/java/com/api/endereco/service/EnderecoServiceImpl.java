package com.api.endereco.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.api.endereco.model.Endereco;
import com.api.endereco.repository.EnderecoRepository;
import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.errors.ApiException;
import com.google.maps.model.GeocodingResult;

@Service
@Transactional
public class EnderecoServiceImpl implements EnderecoService {

	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Override
	public List<Endereco> getAllEndereco() {		
		return this.enderecoRepository.findAll();
	}

	@Override
	public Endereco getEnderecoById(long id) {
		Optional<Endereco> endereco = this.enderecoRepository.findById(id);
		
		if (endereco.isPresent()) {
			return endereco.get();
		} else {
			throw new RuntimeException("Endereço não encontrado");
		}	
	}

	@Override
	public Endereco insertEndereco(Endereco endereco) {		
		if (null == endereco.getLatitude() && null == endereco.getLongitude()) {			
			try {
				StringBuilder sbEndereco = new StringBuilder();
				GeoApiContext geoApicontext = new GeoApiContext.Builder().apiKey("AIzaSyCj0cY2yEvVfYhAaTz3-P2MW-YRKmhz5Uw").build();		
				GeocodingResult[] result;
				
				sbEndereco.append(endereco.getNumber().toString() + ",");
				sbEndereco.append(endereco.getStreetName() + ",");
				sbEndereco.append(endereco.getNeighbourhood() + ",");
				sbEndereco.append(endereco.getCity() + ",");
				sbEndereco.append(endereco.getState());
				
				result = GeocodingApi.geocode(geoApicontext, sbEndereco.toString()).await();	
				
				endereco.setLatitude(result[0].geometry.location.lat);
				endereco.setLongitude(result[0].geometry.location.lng);
			} catch (ApiException | InterruptedException | IOException e) {
				e.printStackTrace();
			}	
		}		
		
		return enderecoRepository.save(endereco);
	}

	@Override
	public Endereco updateEndereco(Endereco endereco) {
		Optional<Endereco> enderecoDB = this.enderecoRepository.findById(endereco.getId());
		
		if (enderecoDB.isPresent()) {			
			return enderecoRepository.save(endereco);
		} else {
			throw new RuntimeException("Endereço não encontrado para atualização de dados");
		}		
	}

	@Override
	public Endereco deleteEndereco(long id) {
		Optional<Endereco> endereco = this.enderecoRepository.findById(id);
		
		if (endereco.isPresent()) {
			this.enderecoRepository.delete(endereco.get());
			return endereco.get();
		} else {
			throw new RuntimeException("Endereço não encontrado para deletar");
		}		
	}

}