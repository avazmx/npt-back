package com.ups.npt.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
@Data
@Entity 
@Table(name="bussines_unit")
public class BussinesUnit {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="bussines_unit_id")
	private Integer id;
	
	@Column(name="name")
	private String name;

	

}
