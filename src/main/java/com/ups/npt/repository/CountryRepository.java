package com.ups.npt.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.ups.npt.model.Country;
import org.springframework.data.jpa.repository.Query;

public interface CountryRepository extends JpaRepository<Country, Integer>{

    
    @Query("FROM Country c WHERE c.id = :id")
    public Country getCountryById(Integer id);
	

}
