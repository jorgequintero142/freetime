package com.jq.secureappbasic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jq.secureappbasic.model.HumanSpecie;
import com.jq.secureappbasic.repo.HumanSpecieRepo;

import java.util.List;

@Service
public class HumanSpecieService {

	@Autowired
	private HumanSpecieRepo humanSpecieRepo;

	public HumanSpecie save(HumanSpecie humanSpecie) {
		return humanSpecieRepo.save(humanSpecie);
	}

	public List<HumanSpecie> findAll() {
		return (List<HumanSpecie>) humanSpecieRepo.findAll();
	}
}
