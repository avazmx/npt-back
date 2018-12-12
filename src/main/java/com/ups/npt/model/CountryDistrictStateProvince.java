/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ups.npt.model;

import java.util.List;
import lombok.Data;

/**
 *
 * @author juancarlos
 */
@Data
public class CountryDistrictStateProvince {
    
    private List<Country> countries;
    
    private List<District> districts;
    
    private List<StateProvince> statesProvinces;
    
    
    
}
