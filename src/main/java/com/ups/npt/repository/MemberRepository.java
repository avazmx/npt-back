package com.ups.npt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.ups.npt.model.Member;
import org.springframework.data.jpa.repository.Query;


public interface MemberRepository  extends JpaRepository<Member, Integer>{
    
    
    @Query("FROM Member m WHERE m.id= :id")
    public Member getMemberById(Integer id);

}
