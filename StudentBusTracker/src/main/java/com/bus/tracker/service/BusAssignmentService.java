package com.bus.tracker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bus.tracker.model.BusAssignment;
import com.bus.tracker.model.Buses;
import com.bus.tracker.repository.BusAssignmentRepository;

@Service
public class BusAssignmentService {
	
	@Autowired
	private BusAssignmentRepository busAssignmentRepository;
	
	public Buses getBusAssignmentByStudentId(Long studentId) {
		BusAssignment busAssignemt= busAssignmentRepository.findByStudentId(studentId).orElse(null);
		return busAssignemt != null ? busAssignemt.getBus() : null;
	}

}
