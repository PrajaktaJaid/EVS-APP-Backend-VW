package com.vwits.constituency.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vwits.constituency.dto.request.ConstituencyRequest;
import com.vwits.constituency.dto.response.ConstituencyResponse;
import com.vwits.constituency.service.ConstituencyService;

@RestController
@RequestMapping("/api/constituency")
public class ContituencyController {

	@PostMapping
	public ResponseEntity<Void> addConstituency(@RequestBody ConstituencyRequest request) {
		_constituencyService.addConstituency(request);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}

	@GetMapping
	public ResponseEntity<List<ConstituencyResponse>> getAllConstituency() {
		List<ConstituencyResponse> allConstituency = _constituencyService.getAllConstituency();
		return ResponseEntity.ok(allConstituency);
	}

	@GetMapping("/{name}")
	public ResponseEntity<Object> getConstituencyIdByName(@PathVariable String name) {
		int constituencyIdByName = _constituencyService.getConstituencyIdByName(name);
		if (constituencyIdByName == 0) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(constituencyIdByName);
	}

	@Autowired
	private ConstituencyService _constituencyService;
}
