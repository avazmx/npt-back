package com.ups.npt.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ups.npt.model.GovernanceLevel;
import org.springframework.data.jpa.repository.Query;

@Repository
public interface GovernanceLevelRepository extends JpaRepository<GovernanceLevel,Integer> {

    @Query("FROM GovernanceLevel gl WHERE gl.id= :id")
    public GovernanceLevel getGovernanceLevelById(Integer id);

}
