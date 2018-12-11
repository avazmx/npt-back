package com.ups.npt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ups.npt.model.CommunityGovernance;
import org.springframework.data.jpa.repository.Query;

public interface CommunityGovernanceRepository extends JpaRepository<CommunityGovernance,Integer>{

    @Query("FROM CommunityGovernance cg WHERE cg.id= :id")
    public CommunityGovernance getcommunityGovernanceRepositoryById(Integer id);

}
