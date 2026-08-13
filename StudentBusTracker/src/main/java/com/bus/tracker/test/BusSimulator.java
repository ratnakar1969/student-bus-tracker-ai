package com.bus.tracker.test;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

import com.bus.tracker.model.Bus;
import com.bus.tracker.model.Route;
import com.bus.tracker.model.Stop;
import com.bus.tracker.service.BusMovementService;
import com.bus.tracker.service.ETAService;

public class BusSimulator {

	public static void main(String[] args) {
		BusMovementService busMovement = new BusMovementService();
		ETAService etaService = new ETAService();

		Stop bachupally = new Stop("Bachupally", 17.5480, 78.3820);

		Stop nizampet = new Stop("Nizampet", 17.5170, 78.3760);

		Stop mayuriNagar = new Stop("Mayuri Nagar", 17.5050, 78.3670);

		Stop kendriyaVihar = new Stop("Kendriya Vihar", 17.4900, 78.3630);

		Stop miyapur = new Stop("Miyapur", 17.4960, 78.3570);

		Stop school = new Stop("School", 17.4700, 78.3500);

		Route route37 = new Route(37, Arrays.asList(bachupally, nizampet, mayuriNagar, school

		));

		Route route40 = new Route(40, Arrays.asList(mayuriNagar, kendriyaVihar, school));

		Route route42 = new Route(42, Arrays.asList(miyapur, school));

		Bus bus37 = new Bus(37, route37, 30, "ON TIME",5);

		Bus bus40 = new Bus(40, route40, 25, "ON TIME",5);

		Bus bus42 = new Bus(42, route42, 28, "DELAYED",5);

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");

		while (true) {

			System.out.println();
			System.out.println("==================================================");
			System.out.println("              STUDENT BUS TRACKER");
			System.out.println("==================================================");

			System.out.println("Updated: " + LocalTime.now().format(formatter));

			displayBus(bus37, etaService);
			displayBus(bus40, etaService);
			displayBus(bus42, etaService);

			System.out.println("==================================================");

			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// Move buses

			busMovement.moveBus(bus37, 5.0);
			busMovement.moveBus(bus40, 5.0);
			busMovement.moveBus(bus42, 5.0);
		}
	}

	private static void displayBus(
	        Bus bus,
	        ETAService etaService) {

	    double distance =
	            etaService.calculateDistanceToNextStop(bus);

	    double eta =
	            etaService.calculateEtaMinutes(bus);

	    String nextStop =
	            etaService.getNextStop(bus);

	    System.out.println();

	    System.out.println(
	            "Bus: " + bus.getId()
	    );

	    System.out.println(
	            "GPS: "
	            + bus.getLatitude()
	            + ", "
	            + bus.getLongitude()
	    );

	    System.out.println(
	            "Speed: "
	            + bus.getSpeed()
	            + " km/h"
	    );

	    System.out.println(
	            "Next Stop: "
	            + nextStop
	    );

	    System.out.println(
	            "Distance: "
	            + String.format("%.2f", distance)
	            + " km"
	    );

	    if (eta >= 0) {

	        System.out.println(
	                "ETA: "
	                + String.format("%.1f", eta)
	                + " minutes"
	        );

	    } else {

	        System.out.println(
	                "ETA: Unknown"
	        );
	    }

	    System.out.println(
	            "Status: "
	            + bus.getStatus()
	    );
	}
}
