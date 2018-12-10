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

import com.ups.npt.model.MannageMembers;
import com.ups.npt.repository.MannageMembersRepository;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@RestController
@RequestMapping("mannage/members")
public class MannageMembersController {

	@Autowired
	MannageMembersRepository mannageMebersRepository;
	
	
	
	@GetMapping()
	public List<MannageMembers> getMannageMembers(){
		return (List<MannageMembers>)mannageMebersRepository.findAll();
	}
	
	@PostMapping()
	@ResponseBody()
	public ResponseEntity<MannageMembers> saveMannageMembers(@RequestBody MannageMembers mannageMembers) {
		try {
			mannageMembers=mannageMebersRepository.save(mannageMembers);
			log.debug("saved ok");
			return new ResponseEntity<>(mannageMembers,HttpStatus.OK); 
		}catch(Exception ex) {
			log.error("Error while serving access level", ex);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
