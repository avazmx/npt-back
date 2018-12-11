package com.ups.npt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ups.npt.model.Community;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CommunityRepository extends JpaRepository<Community, Integer>{
    
            
    @Query("FROM Community c WHERE c.id= :id")
    public Community getCommunityById(@Param("id") Integer id);

}
