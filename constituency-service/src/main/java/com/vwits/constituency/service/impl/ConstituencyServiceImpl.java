package com.vwits.constituency.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vwits.constituency.dto.request.ConstituencyRequest;
import com.vwits.constituency.dto.response.ConstituencyResponse;
import com.vwits.constituency.entity.Constituency;
import com.vwits.constituency.repository.ConstituencyRepository;
import com.vwits.constituency.service.ConstituencyService;

@Service
public class ConstituencyServiceImpl implements ConstituencyService {

	@Override
	public ConstituencyResponse addConstituency(ConstituencyRequest request) {
		Constituency convertConstituencyRequestToConstituency = convertConstituencyRequestToConstituency(request);
		Constituency save = _constituencyRepository.save(convertConstituencyRequestToConstituency);
		return convertConstituencyToConstituencyResponse(save);

	}

	@Override
	public List<ConstituencyResponse> getAllConstituency() {
		// TODO Auto-generated method stub
		List<Constituency> allConstituencies = _constituencyRepository.findAll();
		List<ConstituencyResponse> list = allConstituencies.stream()
				.map(this::convertConstituencyToConstituencyResponse).collect(Collectors.toList());
		return list;
	}

	@Override
	public int getConstituencyIdByName(String name) {
		Constituency byName = _constituencyRepository.findByName(name);
		return byName.getId();
	}

	private Constituency convertConstituencyRequestToConstituency(ConstituencyRequest request) {
		return _modelMapper.map(request, Constituency.class);
	}

	private ConstituencyResponse convertConstituencyToConstituencyResponse(Constituency constituency) {
		return _modelMapper.map(constituency, ConstituencyResponse.class);
	}

	@Autowired
	private ConstituencyRepository _constituencyRepository;

	@Autowired
	private ModelMapper _modelMapper;
}
