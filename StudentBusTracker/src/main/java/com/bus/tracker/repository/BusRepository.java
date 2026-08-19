package com.bus.tracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bus.tracker.model.Buses;

public interface BusRepository extends JpaRepository<Buses, Long> {

}
