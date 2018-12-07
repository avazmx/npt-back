package com.ups.npt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.ups.npt.model.Member;


public interface MemberRepository  extends JpaRepository<Member, Integer>{

}
