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

import com.ups.npt.model.Member;
import com.ups.npt.repository.MemberRepository;
import com.ups.npt.util.Response;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@RestController
@RequestMapping("/member")
public class MemberController {
	
	@Autowired
	private MemberRepository memberRepository;
	
	@Autowired
	Response response;
	
	@GetMapping()
	public List<Member> getMembers(){
		return (List<Member>) memberRepository.findAll();
	}
	
	@PostMapping()
	@ResponseBody()
	public ResponseEntity<HttpStatus> saveMmeber(@RequestBody Member member) {
		try {
			memberRepository.save(member);
			log.debug("saved ok");
			return new ResponseEntity<>(HttpStatus.OK); 
		}catch(Exception ex) {
			log.error("Error while serving access level", ex);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
