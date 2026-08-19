package com.bus.tracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bus.tracker.model.Stop;

public interface StopRepository extends JpaRepository<Stop, Long> {

}
