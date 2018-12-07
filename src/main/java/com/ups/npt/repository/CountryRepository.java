package com.ups.npt.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.ups.npt.model.Country;

public interface CountryRepository extends JpaRepository<Country, Integer>{
	

}
