package com.vwits.voters.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vwits.voters.dto.request.VoterDetailsRequest;
import com.vwits.voters.dto.response.VoterDetailsResponse;
import com.vwits.voters.entity.VoterDetails;
import com.vwits.voters.exception.VoterDetailsNotFound;
import com.vwits.voters.repository.VoterDetailsRepository;
import com.vwits.voters.service.VoterDetailsService;

@Service
public class VoterDetailsServiceImpl implements VoterDetailsService {

	@Override
	public VoterDetailsResponse findVoterDetailsById(int voterId) throws VoterDetailsNotFound {
		Optional<VoterDetails> optional = _voterDetailsRepository.findById(voterId);
		if (optional.isPresent()) {
			VoterDetails voterDetails = optional.get();
			return converVoterDetailsToVoterResponse(voterDetails);

		}
		throw new VoterDetailsNotFound("Voter Details are not found with id: " + voterId);
	}

	@Override
	public long findVoterCountByGender(String gender) {
		List<VoterDetails> voterDetails = _voterDetailsRepository.findByGender(gender);
		System.out.println(voterDetails);
		return voterDetails.size();
	}

	@Override
	public void addNewVoterDeatils(VoterDetailsRequest voterDetailsRequest) {
		VoterDetails convertVoterRequestToVoterDetails = convertVoterRequestToVoterDetails(voterDetailsRequest);
		_voterDetailsRepository.save(convertVoterRequestToVoterDetails);
	}

	@Override
	public List<VoterDetailsResponse> findAllVoterDetails() {
		List<VoterDetails> allVoterDetails = _voterDetailsRepository.findAll();
		List<VoterDetailsResponse> collectResponses = allVoterDetails.stream()
				.map(this::converVoterDetailsToVoterResponse).collect(Collectors.toList());
		return collectResponses;
	}

	private VoterDetailsResponse converVoterDetailsToVoterResponse(VoterDetails voterDetails) {
		return _modelMapper.map(voterDetails, VoterDetailsResponse.class);
	}

	@Override
	public long findTotalVoterDetailsCount() {
		// TODO Auto-generated method stub
		return _voterDetailsRepository.findAll().size();
	}

	private VoterDetails convertVoterRequestToVoterDetails(VoterDetailsRequest detailsRequest) {
		return _modelMapper.map(detailsRequest, VoterDetails.class);
	}

	@Autowired
	private VoterDetailsRepository _voterDetailsRepository;

	@Autowired
	private ModelMapper _modelMapper;

}
