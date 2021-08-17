package com.controltower.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class Address {

	@Setter
	@Getter
	private String country;

	@Setter
	@Getter
	private String state;

	public Address(String country, String state) {
		this.country = country;
		this.state = state;
	}

}
