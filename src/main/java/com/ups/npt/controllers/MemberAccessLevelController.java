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

import com.ups.npt.model.MemberAccessLevel;
import com.ups.npt.repository.MemberAccessLevelRepository;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
@Slf4j
@RestController
@RequestMapping("/member/access/level")
public class MemberAccessLevelController {
	
	@Autowired
	MemberAccessLevelRepository memberAccessLevelRepository;
	
	@GetMapping()
	public List<MemberAccessLevel> getMmeberAccess(){
		return (List<MemberAccessLevel>)memberAccessLevelRepository.findAll();
	}
	
	@PostMapping()
	@ResponseBody()
	public ResponseEntity<MemberAccessLevel> saveMemberAccessLevel(@RequestBody MemberAccessLevel memberAccess) {
		try {
			memberAccess=memberAccessLevelRepository.save(memberAccess);
			log.debug("saved ok");
			return new ResponseEntity<>(memberAccess,HttpStatus.OK); 
		}catch(Exception ex) {
			log.error("Error while serving access level", ex);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
        
        @GetMapping("/{id}")
        @ResponseBody
	public MemberAccessLevel getMemberAccessLevelById(@PathVariable("id") Integer id){
		return memberAccessLevelRepository.getMemberAccessLevelById(id);
	}
	
}
