package com.bus.tracker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.bus.tracker.dto.BusStatusDTO;
import com.bus.tracker.dto.ChildArrivalDTO;
import com.bus.tracker.dto.ParentBusAlertDTO;
import com.bus.tracker.dto.ParentBusStatusDTO;
import com.bus.tracker.model.Bus;
import com.bus.tracker.service.BusAlertService;
import com.bus.tracker.service.BusFleetService;
import com.bus.tracker.service.BusMovementService;

@RestController
public class StudentBusController {
	@Autowired
	BusFleetService busFleetService;

	@Autowired
	BusMovementService busMovementService;

	@Autowired
	BusAlertService busAlertService;
	
	@GetMapping("/studentbustracker/buses/first")
	public ChildArrivalDTO getChildReachingFirst() {

	    return busAlertService.getChildReachingFirst();
	}


	@GetMapping("/studentbustracker/alerts/delayed")
	public List<ParentBusAlertDTO> getDelayedBuses() {

		return busAlertService.getMyDelayedBuses();
	}

	@GetMapping("/studentbustracker/buses")
	public List<Bus> getAllBuses() {

		return busFleetService.getBusFleet();
	}

	@GetMapping("/studentbustracker/buses/status")
	public List<BusStatusDTO> getAllBusStatus() {

		return busMovementService.getAllBusStatus();
	}

	@GetMapping("/studentbustracker/buses/{busId}")
	public BusStatusDTO getBuses(@PathVariable int busId) {
		return busMovementService.getBusStatus(busId);
	}

	@GetMapping("/studentbustracker/buses/{busId}/status")
	public ParentBusStatusDTO getParentBusStatus(@PathVariable int busId) {

		return busMovementService.getParentBusStatus(busId);
	}

}
