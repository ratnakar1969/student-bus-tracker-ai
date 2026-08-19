package com.bus.tracker.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bus.tracker.model.RouteStop;

public interface RouteStopRepository extends JpaRepository<RouteStop, Long> {
	 List<RouteStop> findByRouteIdOrderBySequence(Long routeId);

}
