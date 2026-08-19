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
import com.bus.tracker.entity.Bus;
import com.bus.tracker.model.Buses;
import com.bus.tracker.service.BusAlertService;
import com.bus.tracker.service.BusFleetService;
import com.bus.tracker.service.BusMovementService;
import com.bus.tracker.service.BusSimulationService;

@RestController
public class StudentBusController {
	@Autowired
	BusFleetService busFleetService;
	
	@Autowired
	BusSimulationService busSimulationService;

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
	public List<Buses> getAllBuses() {

		return busFleetService.getBusFleet();
	}

	@GetMapping("/studentbustracker/buses/status")
	public List<BusStatusDTO> getAllBusStatus() {

		return busSimulationService.getAllBusStatus();
	}

	@GetMapping("/studentbustracker/buses/{busId}")
	public BusStatusDTO getBuses(@PathVariable int busId) {
		Bus bus= busSimulationService.getBusByNumber(busId);
		return busMovementService.getBusStatus(bus);
	}
	
	@GetMapping("/studentbustracker/parent/status")
	public List<ParentBusStatusDTO> testParentStatus() {
	    return busAlertService.getMyChildrenBusStatus();
	}



}
