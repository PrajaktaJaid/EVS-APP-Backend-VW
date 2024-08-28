package com.vwits.constituency.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vwits.constituency.entity.Constituency;

@Repository
public interface ConstituencyRepository extends JpaRepository<Constituency, Integer> {
	public Constituency findByName(String name);

}
