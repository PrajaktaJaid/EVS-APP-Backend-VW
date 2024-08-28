package com.vwits.voters.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.vwits.voters.dto.response.ConstituencyResponse;

@FeignClient(name = "api-gateway")
public interface ConstituencyService {
	@GetMapping("/constituency-service/api/constituency/{id}")
	public ConstituencyResponse getConstituencyIdByName(@PathVariable String name);
	
	// public ConstituencyResponse GetVoterDetailsById(@PathVariable int id);

}
