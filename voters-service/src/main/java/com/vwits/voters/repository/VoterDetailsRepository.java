package com.vwits.voters.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vwits.voters.entity.VoterDetails;

public interface VoterDetailsRepository extends JpaRepository<VoterDetails, Integer> {
List<VoterDetails> findByGender(String gender);
}
