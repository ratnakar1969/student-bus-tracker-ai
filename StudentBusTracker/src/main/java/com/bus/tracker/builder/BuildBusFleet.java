package com.bus.tracker.builder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

import com.bus.tracker.entity.Bus;
import com.bus.tracker.entity.Route;
import com.bus.tracker.model.Stop;

@Component
public class BuildBusFleet {
    private List<Bus> busFleet = new ArrayList<>();


public List<Bus> createBuses() {

    if (!busFleet.isEmpty()) {
        return busFleet;
    }

	        // -------------------------
	        // Bus 37
	        // -------------------------

	        Stop bachupally =
	                new Stop("Bachupally", 17.5480, 78.3820);

	        Stop nizampet =
	                new Stop("Nizampet", 17.5170, 78.3760);

	        Stop mayuriNagar =
	                new Stop("Mayuri Nagar", 17.5050, 78.3670);

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

	        Bus bus37 =
	                new Bus(
	                        37,
	                        route37,
	                        30,
	                        "ON TIME",5
	                );

	        bus37.setLatitude(
	                bachupally.getLatitude()
	        );

	        bus37.setLongitude(
	                bachupally.getLongitude()
	        );


	        // -------------------------
	        // Bus 40
	        // -------------------------

	        Stop kendriyaVihar =
	                new Stop(
	                        "Kendriya Vihar",
	                        17.4900,
	                        78.3630
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

	        Bus bus40 =
	                new Bus(
	                        40,
	                        route40,
	                        25,
	                        "ON TIME",5
	                );

	        bus40.setLatitude(
	                mayuriNagar.getLatitude()
	        );

	        bus40.setLongitude(
	                mayuriNagar.getLongitude()
	        );


	        // -------------------------
	        // Bus 42
	        // -------------------------

	        Stop miyapur =
	                new Stop(
	                        "Miyapur",
	                        17.4960,
	                        78.3570
	                );

	        Route route42 =
	                new Route(
	                        42,
	                        Arrays.asList(
	                                miyapur,
	                                school
	                        )
	                );

	        Bus bus42 =
	                new Bus(
	                        42,
	                        route42,
	                        28,
	                        "DELAYED",5
	                );

	        bus42.setLatitude(
	                miyapur.getLatitude()
	        );

	        bus42.setLongitude(
	                miyapur.getLongitude()
	        );


	        // Add buses to fleet

	        busFleet.add(bus37);
	        busFleet.add(bus40);
	        busFleet.add(bus42);
	        return busFleet;
	    }

}
