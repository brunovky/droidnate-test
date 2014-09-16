package com.brunooliveira.droidnate.test.model;

import com.brunooliveira.droidnate.annotations.Column;
import com.brunooliveira.droidnate.annotations.Entity;
import com.brunooliveira.droidnate.annotations.NotNull;

@Entity
public class Address {

	@Column(generatedValue = true)
	private Long id;
	@NotNull
	private String street;
	private int number;

	public Address(String street, int number) {
		this.street = street;
		this.number = number;
	}

	public Address() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

}