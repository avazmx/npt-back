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
@Table(name="country")
public class Country implements java.io.Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="country_id")
	private Integer id;
	
	@Column(name="name")
	private String name;
         
	@Column(name="description")
	private String description;
        
	@Column(name="code")
	private String code;
        
        
        
        
}
