package com.brunooliveira.droidnate.test.model;

import java.util.Calendar;

import com.brunooliveira.droidnate.annotations.Column;
import com.brunooliveira.droidnate.annotations.Entity;
import com.brunooliveira.droidnate.annotations.ForeignKey;
import com.brunooliveira.droidnate.annotations.NotNull;

@Entity
public class User {

	@Column(generatedValue = true)
	private Long id;
	@NotNull
	private String name;
	private boolean admin;
	@Column(name = "date_of_birth")
	private Calendar dateOfBirth;
	@ForeignKey(fieldName = "address_id", objectField = "id")
	private Address address;

	public User(String name, boolean admin, Calendar dateOfBirth, Address address) {
		this.name = name;
		this.admin = admin;
		this.dateOfBirth = dateOfBirth;
		this.address = address;
	}

	public User() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	public Calendar getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Calendar dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

}