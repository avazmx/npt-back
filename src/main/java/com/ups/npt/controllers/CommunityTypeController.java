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

import com.ups.npt.model.CommunityType;
import com.ups.npt.repository.CommunityTypeRepository;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
@Slf4j
@RestController()
@RequestMapping("community/type")
public class CommunityTypeController {
	
	@Autowired
	CommunityTypeRepository communityRepository;
	

	
	@GetMapping()
	public List<CommunityType> getCommunityType(){
		return (List<CommunityType>) communityRepository.findAll();
	}
	
	
	
	@PostMapping()
	@ResponseBody()
	public ResponseEntity<CommunityType> saveCommunityType(@RequestBody CommunityType communityType) {
		try {
			communityType=communityRepository.save(communityType);
			log.debug("saved ok");
			return new ResponseEntity<>(communityType,HttpStatus.OK);
		}catch(Exception ex) {
			log.error("Error while serving access level", ex);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
        
        @GetMapping("/{id}")
        @ResponseBody
	public CommunityType getCommunityTypeById(@PathVariable("id") Integer id){
		return communityRepository.getCommunityTypeById(id);
	}

	
	
}
