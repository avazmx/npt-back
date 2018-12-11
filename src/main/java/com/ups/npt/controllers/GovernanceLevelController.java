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

import com.ups.npt.model.GovernanceLevel;
import com.ups.npt.repository.GovernanceLevelRepository;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
@Slf4j
@RestController
@RequestMapping("/governance/level")
public class GovernanceLevelController {
	
	@Autowired
	GovernanceLevelRepository governanceLevelRepository;
	
	@GetMapping()
	public List<GovernanceLevel> getGovernanceLevel(){
		return (List<GovernanceLevel>) governanceLevelRepository.findAll();
	}
	
	@PostMapping()
	@ResponseBody()
	public ResponseEntity<GovernanceLevel> saveGovernanceLevel(@RequestBody GovernanceLevel governanceLevel) {
		try {
			governanceLevel=governanceLevelRepository.save(governanceLevel);
			log.debug("saved ok");
			return new ResponseEntity<>(governanceLevel,HttpStatus.OK); 
		}catch(Exception ex) {
			log.error("Error while serving access level", ex);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
        
        @GetMapping("/{id}")
        @ResponseBody
	public GovernanceLevel getGovernanceLevelById(@PathVariable("id") Integer id){
		return governanceLevelRepository.getGovernanceLevelById(id);
	}


}
