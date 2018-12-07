package com.ups.npt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ups.npt.model.GeoService;

public interface GeoServiceRepository  extends JpaRepository<GeoService, Integer> {
	
	@Query("from GeoService gs join gs.community c where c.id=:communityId")
	public Iterable<GeoService> findByCategory(@Param("communityId") Integer id);
	
	
}
