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

import com.ups.npt.model.MannageAndMembers;
import com.ups.npt.repository.MannageAndMembersRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/mannage/and/members")
public class MannageAndMembersController {
	
	@Autowired
	MannageAndMembersRepository mannageAndMembersRepository;
	
	@GetMapping
	public List<MannageAndMembers> getMannageAndMembers(){
		return (List<MannageAndMembers>) mannageAndMembersRepository.findAll();
	}
	
	@PostMapping()
	@ResponseBody()
	public ResponseEntity<MannageAndMembers> saveMannageAndMembers(@RequestBody MannageAndMembers mannageAndMembers) {
		try {
			mannageAndMembers=mannageAndMembersRepository.save(mannageAndMembers);
			log.debug("saved ok");
			return new ResponseEntity<>(mannageAndMembers,HttpStatus.OK); 
		}catch(Exception ex) {
			log.error("Error while serving access level", ex);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
