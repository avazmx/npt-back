package com.ups.npt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ups.npt.model.StateProvince;
import java.util.List;
import org.springframework.data.jpa.repository.Query;

public interface StateProvinceRepositorty extends JpaRepository<StateProvince,Integer>{

    
    @Query("FROM StateProvince sp WHERE sp.id= :id")
    public StateProvince getStateProvinceById(Integer id);
    
    @Query("FROM StateProvince sp WHERE sp.district.id= :id")
    public StateProvince getStateProvinceByDistrictId(Integer id);
    
    @Query("FROM StateProvince sp WHERE sp.id IN :ids")
    public List<StateProvince> getServices(List<Integer> ids);
    
    

}
