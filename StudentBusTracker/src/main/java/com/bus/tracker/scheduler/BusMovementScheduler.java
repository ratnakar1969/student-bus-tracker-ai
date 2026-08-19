package com.bus.tracker.scheduler;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.bus.tracker.entity.Bus;
import com.bus.tracker.service.BusFleetService;
import com.bus.tracker.service.BusMovementService;

@Component
public class BusMovementScheduler {

    private BusFleetService busFleetService;
    private BusMovementService movementService;

    public BusMovementScheduler(
            BusFleetService busFleetService,
            BusMovementService movementService) {

        this.busFleetService =
                busFleetService;

        this.movementService =
                movementService;
    }


    @Scheduled(fixedRate = 5000)
    public void moveBuses() {

        for (Bus bus :
                busFleetService.getBusFleet()) {

            movementService.moveBus(
                    bus,
                    5
            );
        }

        System.out.println(
                "Bus positions updated."
        );
    }
}
