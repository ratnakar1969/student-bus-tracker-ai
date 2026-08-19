package com.bus.tracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bus.tracker.model.Routes;


public interface RouteRepository extends JpaRepository<Routes, Long> {

}
