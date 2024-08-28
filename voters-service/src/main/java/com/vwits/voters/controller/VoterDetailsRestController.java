package com.vwits.voters.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vwits.voters.dto.request.VoterDetailsRequest;
import com.vwits.voters.dto.response.VoterDetailsResponse;
import com.vwits.voters.exception.VoterDetailsNotFound;
import com.vwits.voters.service.VoterDetailsService;

@RestController
@RequestMapping("/api/voters")
public class VoterDetailsRestController {
	@GetMapping("/voter-count")
	public ResponseEntity<Long> totalVoterCount() {
	    long voterCount = _voterDetailsService.findTotalVoterDetailsCount();
	    if (voterCount == 0) {
	        return ResponseEntity.noContent().build();
	    }
	    return ResponseEntity.ok(voterCount);
	}

	@GetMapping("/voter-details")
	public ResponseEntity<List<VoterDetailsResponse>> voterDetails() {
	    List<VoterDetailsResponse> voterDetailsResponses = _voterDetailsService.findAllVoterDetails();
	    if (voterDetailsResponses == null || voterDetailsResponses.isEmpty()) {
	        return ResponseEntity.notFound().build();
	    }
	    return ResponseEntity.ok(voterDetailsResponses);
	}

	@GetMapping("/voter-details/{voterId}")
	public ResponseEntity<VoterDetailsResponse> voterDetailsById(@PathVariable int voterId) throws VoterDetailsNotFound
	{
		VoterDetailsResponse voterDetailsResponse = _voterDetailsService.findVoterDetailsById(voterId);
		if (voterDetailsResponse == null) {
	        return ResponseEntity.notFound().build();
	    }
	    return ResponseEntity.ok(voterDetailsResponse);
	}
	
	@GetMapping("/voter-count-by-gender/{gender}")
	public ResponseEntity<Long> voterDetailsByGender(@PathVariable String gender){
		long voterDetailsResponses = _voterDetailsService.findVoterCountByGender(gender);
	    return ResponseEntity.ok(voterDetailsResponses);
	}
	
	@PostMapping
	public ResponseEntity<Void> addVoterDetails(@RequestBody VoterDetailsRequest voterDetailsRequest){
		_voterDetailsService.addNewVoterDeatils(voterDetailsRequest);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	@Autowired
	private VoterDetailsService _voterDetailsService;
}
