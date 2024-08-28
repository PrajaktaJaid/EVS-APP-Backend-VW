package com.vwits.constituency.service;

import java.util.List;

import com.vwits.constituency.dto.request.ConstituencyRequest;
import com.vwits.constituency.dto.response.ConstituencyResponse;

public interface ConstituencyService {
	ConstituencyResponse addConstituency(ConstituencyRequest request);
	List<ConstituencyResponse> getAllConstituency();
	int getConstituencyIdByName(String constituencyName);
}
