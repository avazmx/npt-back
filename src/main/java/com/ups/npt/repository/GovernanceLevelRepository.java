package com.ups.npt.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ups.npt.model.GovernanceLevel;

@Repository
public interface GovernanceLevelRepository extends JpaRepository<GovernanceLevel,Integer> {

}
