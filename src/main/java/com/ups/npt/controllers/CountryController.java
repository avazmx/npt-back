package com.ups.npt.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ups.npt.model.Country;
import com.ups.npt.repository.CountryRepository;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@RestController
@RequestMapping("/countries")
public class CountryController {
	
	@Autowired
	CountryRepository countryRepository;

	@GetMapping()
	public List<Country> getCountries(){
		return (List<Country>) countryRepository.findAll();
	}
	
	@PostMapping()
	public ResponseEntity<Country> saveCountry(@RequestBody Country country) {
	   try {
		   country=countryRepository.save(country);
		   log.debug("saved ok");
		   return new ResponseEntity<>(country,HttpStatus.OK); 
	   }catch(Exception ex) {
		   log.error("Error while serving access level", ex);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
