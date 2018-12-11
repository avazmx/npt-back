package com.ups.npt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ups.npt.model.GeoService;

public interface GeoServiceRepository  extends JpaRepository<GeoService, Integer> {
	
    @Query("FROM GeoService gs WHERE gs.id= :id")
    public GeoService getGeoServiceById(Integer id);
	
	
}
