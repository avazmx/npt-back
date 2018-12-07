package com.ups.npt.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.stereotype.Repository;

import lombok.Data;
@Data
@Entity
@Repository(value="state_province")
public class StateProvince {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="state_province_id")
	private Integer id;
	
	@Column(name="name")
	private String name;
	
	@ManyToOne
    @JoinColumn(name="district", nullable=false)
	private District district;

}
