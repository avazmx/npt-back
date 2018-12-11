package com.ups.npt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ups.npt.model.BussinesUnit;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BussinesUnitRepository extends JpaRepository<BussinesUnit, Integer>{
    
    
    @Query("FROM BussinesUnit bu WHERE bu.id= :id")
    public BussinesUnit getBussinesUnitById(@Param("id") Integer id);
	
}