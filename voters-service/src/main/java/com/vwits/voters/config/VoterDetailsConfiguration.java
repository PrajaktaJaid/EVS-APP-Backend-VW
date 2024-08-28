package com.vwits.voters.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class VoterDetailsConfiguration {

	@Bean
	public ModelMapper getMapper() {
		return new ModelMapper();
	}
}
