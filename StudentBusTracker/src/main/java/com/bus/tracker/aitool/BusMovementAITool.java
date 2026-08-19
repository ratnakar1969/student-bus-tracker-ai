package com.bus.tracker.aitool;

import org.springframework.ai.tool.annotation.Tool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bus.tracker.dto.BusStatusDTO;
import com.bus.tracker.entity.Bus;
import com.bus.tracker.service.BusMovementService;
import com.bus.tracker.service.BusSimulationService;

@Component
public class BusMovementAITool {
    
	@Autowired
	BusMovementService busMovementService;
	
	@Autowired
	BusSimulationService busSimulationService;


  

    @Tool(description = "Get the current location, speed, status, next stop and ETA of a student bus. Use this when a parent asks about a specific bus.")
    public BusStatusDTO getBusStatus(int busId) {
    	
    	Bus bus= busSimulationService.getBusByNumber(busId);
        return busMovementService.getBusStatus(bus);
    }

}
