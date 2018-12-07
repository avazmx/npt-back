package com.ups.npt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ups.npt.model.District;

@Repository
public interface DistrictRepositorty extends JpaRepository<District, Integer>{

}
