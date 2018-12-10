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
@Table(name="mannager_and_members")
public class MannageAndMembers {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "mannage_and_members_id")
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "member")
	private Member member;
	
	@ManyToOne
	@JoinColumn(name = "mannage_members")
	private MannageMembers mannageMembers;
	
	@ManyToOne
	@JoinColumn(name = "access_level")
	private AccessLevel accessLevel;

}
