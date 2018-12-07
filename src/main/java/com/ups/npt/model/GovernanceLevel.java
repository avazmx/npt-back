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
@Table(name = "governance_level")
public class GovernanceLevel {
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 @Column(name="governance_level_id")
	 private Integer id;
	 @Column(name="name")
	 private String name;
	 @Column(name="description")
	 private String description;

}
