package com.example.demo.model;

import java.util.Date;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import edu.umd.cs.findbugs.annotations.NonNull;

@Table
public class User {
	 @PrimaryKey 
	 private @NonNull String useId;
	 private @NonNull String firstName;
	 private @NonNull String lastName;
	 private @NonNull String email;
	 private @NonNull String password;
	 private @NonNull String gender;
	 private @NonNull Date dateOfBirth;
	 public User() {
	}
	
	public User(String useId, String firstName, String lastName, String email, String password, String gender,
			Date dateOfBirth) {
		super();
		this.useId = useId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.gender = gender;
		this.dateOfBirth = dateOfBirth;
	}

	public String getUseId() {
		return useId;
	}
	public void setUseId(String useId) {
		this.useId = useId;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	 
	 
}
