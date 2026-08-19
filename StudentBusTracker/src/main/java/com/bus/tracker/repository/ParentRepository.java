package com.bus.tracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bus.tracker.model.Parents;

public interface ParentRepository extends JpaRepository<Parents, Long> {

}
