package com.knowroaming.rfonseca.pojo;


public class UsageInformation {

	private int UsageInformationId;
	private int typeOfUsage;
	private String dateOfUsage;

	// ManyToOne
	private int userId;

	public UsageInformation() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UsageInformation(int typeOfUsage, String dateOfUsage, int userId) {
		super();
		this.typeOfUsage = typeOfUsage;
		this.dateOfUsage = dateOfUsage;
		this.userId = userId;
	}

	public int getUsageInformationId() {
		return UsageInformationId;
	}

	public void setUsageInformationId(int usageInformationId) {
		UsageInformationId = usageInformationId;
	}

	public int getTypeOfUsage() {
		return typeOfUsage;
	}

	public void setTypeOfUsage(int typeOfUsage) {
		this.typeOfUsage = typeOfUsage;
	}

	public String getDateOfUsage() {
		return dateOfUsage;
	}

	public void setDateOfUsage(String dateOfUsage) {
		this.dateOfUsage = dateOfUsage;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

}
