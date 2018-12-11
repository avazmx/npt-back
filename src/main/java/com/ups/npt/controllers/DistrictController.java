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

import com.ups.npt.model.District;
import com.ups.npt.repository.DistrictRepositorty;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
@Slf4j
@RestController
@RequestMapping("/district")
public class DistrictController {
	
	@Autowired
	DistrictRepositorty districtRepository;
	
	@GetMapping()
	public List<District> getDistricts(){
		return (List<District>) districtRepository.findAll();
	}
	
	@PostMapping()
	@ResponseBody()
	public ResponseEntity<District> saveDistrict(@RequestBody District district) {
		try {
			district=districtRepository.save(district);
			log.debug("saved ok");
			   return new ResponseEntity<>(district,HttpStatus.OK); 
		}catch(Exception ex) {
			log.error("Error while serving access level", ex);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
        
        @GetMapping("/{id}")
        @ResponseBody
	public District getDistrictlById(@PathVariable("id") Integer id){
		return districtRepository.getDistrictlById(id);
	}
        
        @GetMapping("/country/{id}")
        @ResponseBody
	public List<District> getDistrictslByCountryId(@PathVariable("id") Integer id){
		return districtRepository.getDistrictslByCountryId(id);
	}
        

}
