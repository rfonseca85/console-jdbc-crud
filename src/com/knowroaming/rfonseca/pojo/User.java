package com.knowroaming.rfonseca.pojo;

import java.util.List;

public class User {

	private int userId;
	private String name;
	private String email;
	private String country;
	private String phoneNumber;

	// OneToMany
	private List<UsageInformation> usageInformationList;

	public User() {
		super();
	}

	public User(String name, String email, String country, String phoneNumber) {
		super();
		this.name = name;
		this.email = email;
		this.country = country;
		this.phoneNumber = phoneNumber;
	}

	//Getter and Setters
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	
	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public List<UsageInformation> getUsageInformationList() {
		return usageInformationList;
	}

	public void setUsageInformationList(List<UsageInformation> usageInformationList) {
		this.usageInformationList = usageInformationList;
	}

}
