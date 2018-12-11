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

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
@Slf4j
@RestController
@RequestMapping("/member")
public class MemberController {
	
	@Autowired
	private MemberRepository memberRepository;
	

	
	@GetMapping()
	public List<Member> getMembers(){
		return (List<Member>) memberRepository.findAll();
	}
	
	@PostMapping()
	@ResponseBody()
	public ResponseEntity<Member> saveMmeber(@RequestBody Member member) {
		try {
			member=memberRepository.save(member);
			log.debug("saved ok");
			return new ResponseEntity<>(member,HttpStatus.OK); 
		}catch(Exception ex) {
			log.error("Error while serving access level", ex);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
        
        @GetMapping("/{id}")
        @ResponseBody
	public Member getMemberById(@PathVariable("id") Integer id){
		return memberRepository.getMemberById(id);
	}


}
