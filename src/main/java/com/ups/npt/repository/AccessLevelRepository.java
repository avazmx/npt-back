package com.ups.npt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ups.npt.model.AccessLevel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AccessLevelRepository  extends JpaRepository<AccessLevel, Integer>{
    
   
    @Query("FROM AccessLevel al WHERE al.id= :id")
    public AccessLevel getAccessLevelById(@Param("id") Integer id);
    
    
}
