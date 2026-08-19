package com.bus.tracker.scheduler;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.bus.tracker.entity.Bus;
import com.bus.tracker.model.Buses;
import com.bus.tracker.service.BusFleetService;
import com.bus.tracker.service.BusMovementService;
import com.bus.tracker.service.BusSimulationService;

@Component
public class BusMovementScheduler {

    private BusSimulationService busSimulationService;
    private BusMovementService movementService;

    public BusMovementScheduler(
    		BusSimulationService busSimulationService,
            BusMovementService movementService) {

        this.busSimulationService = busSimulationService;

        this.movementService =
                movementService;
    }


    @Scheduled(fixedRate = 5000)
    public void moveBuses() {
    	 for (Bus bus : busSimulationService.getBuses()) {
    		 movementService.moveBus(bus, 5.0);
    	    }
       
    }
}
