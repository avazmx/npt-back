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
@Table(name="community")
public class Community {
	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="community_id")
	private Integer id;
	@Column(name="name")
	private String name;
	@ManyToOne
    @JoinColumn(name = "community_type") 
	private CommunityType communityType;

	
	
	
	
	 

}
