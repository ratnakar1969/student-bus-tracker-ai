package com.bus.tracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bus.tracker.model.Parents;
import com.bus.tracker.model.Students;


public interface StudentRepository extends JpaRepository<Students, Long>{
	Students findByName(String name);
	
	Parents findByParentId(Long parentId);
	
	Parents findByParentIdAndName(Long parentId, String name);

}

