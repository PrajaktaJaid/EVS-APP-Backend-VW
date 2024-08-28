package com.vwits.voters.service;

import java.util.List;

import com.vwits.voters.dto.request.VoterDetailsRequest;
import com.vwits.voters.dto.response.VoterDetailsResponse;
import com.vwits.voters.exception.VoterDetailsNotFound;

public interface VoterDetailsService {

	VoterDetailsResponse findVoterDetailsById(int voterId)throws VoterDetailsNotFound;

	long findVoterCountByGender(String gender);

	void addNewVoterDeatils(VoterDetailsRequest voterDetailsRequest);

	long findTotalVoterDetailsCount();

	List<VoterDetailsResponse> findAllVoterDetails();

}
