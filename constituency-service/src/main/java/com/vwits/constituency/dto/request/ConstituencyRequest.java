package com.vwits.constituency.dto.request;

public class ConstituencyRequest {

	private String name;

	public ConstituencyRequest(String name) {
		super();
		this.name = name;
	}

	public ConstituencyRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
