package com.ups.npt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ups.npt.model.MannageMembers;
import org.springframework.data.jpa.repository.Query;

public interface MannageMembersRepository extends JpaRepository<MannageMembers, Integer>{
    
    
    @Query("FROM MannageMembers mm WHERE mm.id= :id")
    public MannageMembers getMannageMembersById(Integer id);

}
