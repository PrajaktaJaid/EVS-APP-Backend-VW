package com.vwits.constituency;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@EnableDiscoveryClient
@SpringBootApplication
public class ConstituencyServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConstituencyServiceApplication.class, args);
	}

}
