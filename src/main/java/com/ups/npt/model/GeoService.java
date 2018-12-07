package com.ups.npt.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
@Data
@Entity
@Table(name="geo_services")
public class GeoService {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="geo_services_id")
	private Integer id;
	
	@ManyToOne
    @JoinColumn(name = "community") 
	private Community community;
	
	@ManyToOne
    @JoinColumn(name = "state_province") 
	private StateProvince stateProvince;
	
	@Column(name="slic_range_low")
	private int slicRangeLow;
	
	@Column(name="slic_range_high")
	private int slicRangeHigh;
	
	@ManyToOne
    @JoinColumn(name = "bussines_unit") 
	private BussinesUnit bussinesUnit;
	
	@Column(name="gnd")
	private boolean gnd;
	
	@Column(name="treeds")
	private boolean treeds;
	
	@Column(name="twods")
	private boolean twods;
	
	@Column(name="oneds")
	private boolean oneds;

}
