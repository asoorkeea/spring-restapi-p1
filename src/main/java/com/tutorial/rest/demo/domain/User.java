package com.tutorial.rest.demo.domain;

public class User {

	private String id;
	private String firstName;
	private String lastName;
	private String gender;
	private String dateOfBirth;
	
	public User() {
		
	}
	
	public User(String id, String firstName, String lastName, String gender, String dateOfBirth) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.dateOfBirth = dateOfBirth;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("[");
		builder.append("id->").append(id).append(",");
		builder.append("firstName->").append(firstName).append(",");
		builder.append("lastName->").append(lastName).append(",");
		builder.append("gender->").append(gender).append(",");
		builder.append("dateOfBirth->").append(dateOfBirth);
		builder.append("]");
		return builder.toString();
	}
	
}
