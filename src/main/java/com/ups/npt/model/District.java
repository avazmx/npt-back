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
@Table(name="district")
public class District {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="district_id")
	private Integer id;
	
	@Column(name="name")
	private String name;
	
	@ManyToOne
    @JoinColumn(name="country", nullable=false)
	private Country country;

	

}
