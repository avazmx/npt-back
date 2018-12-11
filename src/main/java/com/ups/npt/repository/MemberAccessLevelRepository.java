package com.ups.npt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ups.npt.model.MemberAccessLevel;
import org.springframework.data.jpa.repository.Query;

public interface MemberAccessLevelRepository extends JpaRepository<MemberAccessLevel, Integer> {

    

    @Query("FROM MemberAccessLevel al WHERE al.id= :id")
    public MemberAccessLevel getMemberAccessLevelById(Integer id);

}
