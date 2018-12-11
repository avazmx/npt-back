package com.ups.npt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ups.npt.model.CommunityType;
import org.springframework.data.jpa.repository.Query;

public interface CommunityTypeRepository extends JpaRepository<CommunityType, Integer>{

    
    @Query("FROM CommunityType ct WHERE ct.id= :id")
    public CommunityType getCommunityTypeById(Integer id);
    

}
