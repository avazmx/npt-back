package com.ups.npt.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="community_governance")
public class CommunityGovernance {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="community_governance_id")
	private Integer id;
	
	@OneToOne
	@JoinColumn(name = "mannage_members") 
	private MannageMembers mannageMembers;
	
	@OneToOne
	@JoinColumn(name = "level_one_approver") 
	private Member levelOneApprover;
	
	@OneToOne
	@JoinColumn(name = "at_level_one_approver") 
	private Member atLevelOneApprover;
	
	@OneToOne
	@JoinColumn(name = "level_two_approver") 
	private Member levelTwoApprover;
	
	@OneToOne
	@JoinColumn(name = "at_level_two_approver") 
	private Member atLevelTwoApprover;
	
	
	
	
		   

}
