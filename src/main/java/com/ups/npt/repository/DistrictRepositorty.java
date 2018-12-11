package com.ups.npt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ups.npt.model.District;
import java.util.List;
import org.springframework.data.jpa.repository.Query;

@Repository
public interface DistrictRepositorty extends JpaRepository<District, Integer>{
    
    @Query("FROM District d WHERE d.id= :id")
    public District getDistrictlById(Integer id);

    @Query("FROM District d WHERE d.country.id= :id")
    public List<District> getDistrictslByCountryId(Integer id);

}
