package com.api.endereco.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class Endereco {
	
	@Id
	@GeneratedValue
	private long id;
	
	@NotEmpty(message = "A rua é obrigatório.")
	private String streetName;
	
	@NotNull(message = "O número é obrigatório.")
	private Integer number;	
	
	@NotEmpty(message = "O bairro é obrigatório.")
	private String neighbourhood;
	
	@NotEmpty(message = "A cidade é obrigatório.")
	private String city;
	
	@NotEmpty(message = "O estado é obrigatório.")
	private String state;
	
	@NotEmpty(message = "O país é obrigatório.")
	private String country;
	
	@NotEmpty(message = "O cep é obrigatório.")
	private String zipcode;
	
	private String complement;
	
	private Double latitude;
	
	private Double longitude;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getNeighbourhood() {
		return neighbourhood;
	}

	public void setNeighbourhood(String neighbourhood) {
		this.neighbourhood = neighbourhood;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getComplement() {
		return complement;
	}

	public void setComplement(String complement) {
		this.complement = complement;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

}