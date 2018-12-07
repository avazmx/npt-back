package com.ups.npt.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ups.npt.model.StateProvince;
import com.ups.npt.repository.StateProvinceRepositorty;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@RestController
@RequestMapping("/state/province")
public class StateProvinceController {
	
	@Autowired
	StateProvinceRepositorty stateProvinceRepository;

	@GetMapping()
	public List<StateProvince> getStateProvince(){
		return  (List<StateProvince>) stateProvinceRepository.findAll();
	}
	
	@PostMapping()
	@ResponseBody()
	public ResponseEntity<HttpStatus> saveStateProvince(@RequestBody StateProvince stateProvince) {
		try {
			stateProvinceRepository.save(stateProvince);
			log.debug("saved ok");
			return new ResponseEntity<>(HttpStatus.OK); 
		}catch(Exception ex) {
			log.error("Error while serving access level", ex);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}

