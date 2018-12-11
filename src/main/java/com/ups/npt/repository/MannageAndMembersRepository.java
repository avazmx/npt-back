package com.ups.npt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ups.npt.model.MannageAndMembers;
import org.springframework.data.jpa.repository.Query;

public interface MannageAndMembersRepository extends JpaRepository<MannageAndMembers, Integer> {

    

    @Query("FROM MannageAndMembers mb WHERE mb.id= :id")
    public MannageAndMembers getMannageAndMembersById(Integer id);

}
