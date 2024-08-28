package com.vwits.voters.dto.request;

public class VoterDetailsRequest {
	private String name;
	private int age;
	private String gender;
	private int constituencyId; 

	public VoterDetailsRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	public VoterDetailsRequest(String name, int age, String gender,int constituencyId) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.constituencyId =constituencyId;
	}

	public int getConstituencyId() {
		return constituencyId;
	}

	public void setConstituencyId(int constituencyId) {
		this.constituencyId = constituencyId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

}
