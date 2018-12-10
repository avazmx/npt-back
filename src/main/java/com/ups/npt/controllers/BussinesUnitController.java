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

import com.ups.npt.model.BussinesUnit;
import com.ups.npt.repository.BussinesUnitRepository;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@RestController
@RequestMapping("/bussines/unit")
public class BussinesUnitController {
	
	@Autowired
	BussinesUnitRepository	bussinesUnitRepository;
	
	
	
	@GetMapping()
	public List<BussinesUnit> getBussinesUnit(){
		return (List<BussinesUnit>)bussinesUnitRepository.findAll();
	}
	
	@PostMapping()
	@ResponseBody()
	public ResponseEntity<BussinesUnit> saveBussinesUnit(@RequestBody BussinesUnit bussinesUnit) {
		try {
			bussinesUnit=bussinesUnitRepository.save(bussinesUnit);
			log.debug("saved ok");
			return new ResponseEntity<>(bussinesUnit,HttpStatus.OK);
		}catch(Exception ex) {
			log.error("Error while serving access level", ex);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	
}
