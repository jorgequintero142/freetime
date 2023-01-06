package com.jq.secureappbasic.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jq.secureappbasic.model.HumanSpecie;
import com.jq.secureappbasic.service.HumanSpecieService;

@RestController
@RequestMapping("/api/v1/humanspecie")
public class HumanSpeciesRest {

	@Autowired
	HumanSpecieService humanSpecieService;

	@GetMapping("/all")
	public ResponseEntity<List<HumanSpecie>> getAll() {

		try {
			return new ResponseEntity(humanSpecieService.findAll(), HttpStatus.ACCEPTED);
		} catch (Exception e) {
			return new ResponseEntity("Error unexpected", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
