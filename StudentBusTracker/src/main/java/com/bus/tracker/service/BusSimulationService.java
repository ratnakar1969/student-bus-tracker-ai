package com.bus.tracker.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.bus.tracker.dto.BusStatusDTO;
import com.bus.tracker.entity.Bus;
import com.bus.tracker.entity.Route;
import com.bus.tracker.model.Stop;

@Service
public class BusSimulationService {

	private List<Bus> buses = new ArrayList<Bus>();
	private final BusMovementService busMovementService;
	
	

    public BusSimulationService(BusMovementService busMovementService) {

        this.busMovementService = busMovementService;
        
		Stop bachupally =
                new Stop("Bachupally", 17.5480, 78.3820);

        Stop nizampet =
                new Stop("Nizampet", 17.5170, 78.3760);

        Stop mayuriNagar =
                new Stop("Mayuri Nagar", 17.5050, 78.3670);

        Stop kendriyaVihar =
                new Stop("Kendriya Vihar", 17.4900, 78.3630);

        Stop miyapur =
                new Stop("Miyapur", 17.4960, 78.3570);

        Stop school =
                new Stop("School", 17.4700, 78.3500);

        Route route37 =
                new Route(
                        37,
                        Arrays.asList(
                                bachupally,
                                nizampet,
                                mayuriNagar,
                                school
                        )
                );

        Route route40 =
                new Route(
                        40,
                        Arrays.asList(
                                mayuriNagar,
                                kendriyaVihar,
                                school
                        )
                );

        Route route42 =
                new Route(
                        42,
                        Arrays.asList(
                                miyapur,
                                school
                        )
                );

        Bus bus37 =
                new Bus(
                        37,
                        route37,
                        30,
                        "ON TIME",
                        5
                );

        Bus bus40 =
                new Bus(
                        40,
                        route40,
                        25,
                        "ON TIME",
                        5
                );

        Bus bus42 =
                new Bus(
                        42,
                        route42,
                        28,
                        "DELAYED",
                        5
                );

        buses = Arrays.asList(
                bus37,
                bus40,
                bus42
        );
    }

    public Bus getBusByNumber(int busId) {

        return buses.stream()
                .filter(bus -> bus.getId() == busId)
                .findFirst()
                .orElse(null);
    }

    public List<Bus> getBuses() {

        return buses;
    }
    
    
    public List<BusStatusDTO> getAllBusStatus() {

        List<BusStatusDTO> result = new ArrayList<>();

        for (Bus bus : buses) {

            result.add(
                    busMovementService.getBusStatus(bus)
            );
        }

        return result;
    }

    
    @Scheduled(fixedRate = 5000)
    public void updateSimulation() {

        for (Bus bus : buses) {

            busMovementService.moveBus(
                    bus,
                    5.0
            );
        }
    }
}