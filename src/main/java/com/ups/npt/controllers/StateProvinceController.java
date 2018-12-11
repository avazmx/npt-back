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

import com.ups.npt.model.StateProvince;
import com.ups.npt.repository.StateProvinceRepositorty;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
@Slf4j
@RestController
@RequestMapping("/state/province")
public class StateProvinceController {
	
	@Autowired
	StateProvinceRepositorty stateProvinceRepository;

	@GetMapping()
	public List<StateProvince> getStateProvince(){
		return  (List<StateProvince>) stateProvinceRepository.findAll();
	}
	
	@PostMapping()
	@ResponseBody()
	public ResponseEntity<StateProvince> saveStateProvince(@RequestBody StateProvince stateProvince) {
		try {
			stateProvince=stateProvinceRepository.save(stateProvince);
			log.debug("saved ok");
			return new ResponseEntity<>(stateProvince,HttpStatus.OK); 
		}catch(Exception ex) {
			log.error("Error while serving access level", ex);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
        
        @GetMapping("/{id}")
        @ResponseBody
	public StateProvince getStateProvinceById(@PathVariable("id") Integer id){
		return stateProvinceRepository.getStateProvinceById(id);
	}
        
        @GetMapping("/district/{id}")
        @ResponseBody
	public StateProvince getStateProvinceByDistrictId(@PathVariable("id") Integer id){
		return stateProvinceRepository.getStateProvinceByDistrictId(id);
	}
        
        @PostMapping("/services")
        @ResponseBody
	public List<StateProvince> getStateProvinceByDistrictId(@RequestBody List<Integer> ids){
                System.out.println("parametros"+ ids.toString());
		return stateProvinceRepository.getServices(ids);
	}


}

