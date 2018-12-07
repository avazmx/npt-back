package com.ups.npt.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ups.npt.model.GeoService;
import com.ups.npt.repository.GeoServiceRepository;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@RestController
@RequestMapping("/geo/service")
public class GeoServiceController {
	
	@Autowired
	private GeoServiceRepository geoServiceRepository;
	
	
	
	@GetMapping()
	public List<GeoService> getCommunities(){
		return (List<GeoService>) geoServiceRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public List<GeoService> getGeoServicesByCommunityId(@PathVariable Integer id){
		return (List<GeoService>) geoServiceRepository.findByCategory(id);
	}
	
	
	@PostMapping()
	@ResponseBody()
	public ResponseEntity<HttpStatus> saveGeoService(@RequestBody GeoService geoService) {
		try {
			geoServiceRepository.save(geoService);
			log.debug("saved ok");
			return new ResponseEntity<>(HttpStatus.OK); 
		}catch(Exception ex) {
			log.error("Error while serving access level", ex);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	
	

}
