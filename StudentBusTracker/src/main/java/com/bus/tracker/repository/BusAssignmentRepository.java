package com.bus.tracker.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bus.tracker.model.BusAssignment;

public interface BusAssignmentRepository extends JpaRepository<BusAssignment, Long> {
	Optional<BusAssignment> findByStudentId(Long studentId);

}
