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

import com.ups.npt.model.AccessLevel;
import com.ups.npt.repository.AccessLevelRepository;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@RestController
@RequestMapping("/access/level")
public class AccessLevelController {
	
	@Autowired
	AccessLevelRepository accessLevelRepository;
	
	
	@GetMapping()
	public List<AccessLevel> getBussinesUnit(){
		return (List<AccessLevel>)accessLevelRepository.findAll();
	}
	
	@PostMapping()
	@ResponseBody()
	public ResponseEntity<HttpStatus> saveAccessLevel(@RequestBody AccessLevel accessLevel) {
		try {
			accessLevelRepository.save(accessLevel);
			log.debug("saved ok");
			return new ResponseEntity<>(HttpStatus.OK);
		}catch(Exception ex) {
			log.error("Error while serving access level", ex);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	
	

}
