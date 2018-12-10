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
@Table(name="mannage_members")
public class MannageMembers {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "mannage_members_id")
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
	private int slicRangehigh;
	
	

}
