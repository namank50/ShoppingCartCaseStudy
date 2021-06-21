package com.casestudy.APIGateway.Model;

public class SecurityResponse {

	private final String jwt;

	public SecurityResponse(String jwt) {
		super();
		this.jwt = jwt;
	}

	public String getJwt() {
		return jwt;
	}

}
