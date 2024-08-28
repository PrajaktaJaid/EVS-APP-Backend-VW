package com.vwits.voters.dto.response;

public class ConstituencyResponse {
	
	private int id;
	private String name;
	
	public ConstituencyResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ConstituencyResponse(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	

}
