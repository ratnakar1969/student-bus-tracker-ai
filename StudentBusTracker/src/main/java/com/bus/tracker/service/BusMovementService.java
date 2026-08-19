package com.bus.tracker.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bus.tracker.dto.BusStatusDTO;
import com.bus.tracker.dto.ParentBusStatusDTO;
import com.bus.tracker.entity.Bus;
import com.bus.tracker.entity.Route;
import com.bus.tracker.exception.BusNotFoundException;
import com.bus.tracker.model.Stop;

@Service
public class BusMovementService {

	@Autowired
	BusFleetService busFleetService;

	@Autowired
	ETAService etaService;

	public BusMovementService(BusFleetService busFleetService, ETAService etaService) {

		this.busFleetService = busFleetService;

		this.etaService = etaService;
	}

	public BusMovementService() {
		// TODO Auto-generated constructor stub
	}

	public BusStatusDTO getBusStatus(int busId) {

		Bus bus = busFleetService.getBus(busId);

		   if (bus == null) {
		        throw new BusNotFoundException(busId);
		    }

		BusStatusDTO status = new BusStatusDTO();

		status.setBusId(bus.getId());

		status.setLatitude(bus.getLatitude());

		status.setLongitude(bus.getLongitude());
		status.setSpeed(bus.getSpeed());

		status.setNextStop(etaService.getNextStop(bus));

		status.setDistanceKm(etaService.calculateDistanceToNextStop(bus));

		status.setEtaMinutes(etaService.calculateEtaMinutes(bus));

		status.setStatus(
			    etaService.calculateStatus(bus)
			);

		return status;
	}

	public void moveBus(Bus bus, double intervalSeconds) {

		Route route = bus.getRoute();

		int currentIndex = bus.getCurrentStopIndex();

		// Bus has reached the final stop
		if (currentIndex >= route.getStops().size() - 1) {
			return;
		}

		Stop currentStop = route.getStops().get(currentIndex);

		Stop nextStop = route.getStops().get(currentIndex + 1);

		double currentLatitude = bus.getLatitude();

		double currentLongitude = bus.getLongitude();

		double distanceToNextStop = calculateDistance(currentLatitude, currentLongitude, nextStop.getLatitude(),
				nextStop.getLongitude());

		/*
		 * Distance travelled during this simulation interval.
		 *
		 * speed = km/hour
		 */

		double distanceTravelled = bus.getSpeed() * (intervalSeconds / 3600.0);

		// We reached the next stop
		if (distanceTravelled >= distanceToNextStop) {

			bus.setCurrentStopIndex(currentIndex + 1);

			bus.setLatitude(nextStop.getLatitude());

			bus.setLongitude(nextStop.getLongitude());

			return;
		}

		/*
		 * Otherwise move part of the way toward the next stop.
		 */

		double fraction = distanceTravelled / distanceToNextStop;

		double newLatitude = currentLatitude + (nextStop.getLatitude() - currentLatitude) * fraction;

		double newLongitude = currentLongitude + (nextStop.getLongitude() - currentLongitude) * fraction;

		bus.setLatitude(newLatitude);
		bus.setLongitude(newLongitude);
	}

	private double calculateDistance(double lat1, double lon1, double lat2, double lon2) {

		final double EARTH_RADIUS = 6371.0;

		double lat1Rad = Math.toRadians(lat1);

		double lat2Rad = Math.toRadians(lat2);

		double deltaLat = Math.toRadians(lat2 - lat1);

		double deltaLon = Math.toRadians(lon2 - lon1);

		double a = Math.sin(deltaLat / 2) * Math.sin(deltaLat / 2)
				+ Math.cos(lat1Rad) * Math.cos(lat2Rad) * Math.sin(deltaLon / 2) * Math.sin(deltaLon / 2);

		double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

		return EARTH_RADIUS * c;
	}
	
	
	public ParentBusStatusDTO getParentBusStatus(int busId) {

	    Bus bus =
	            busFleetService.getBus(busId);
	    if (bus == null) {
	        throw new BusNotFoundException(busId);
	    }

	
	    String nextStop =
	            etaService.getNextStop(bus);

	    double eta =
	            etaService.calculateEtaMinutes(bus);

	    return new ParentBusStatusDTO(
	            bus.getId(),
	            bus.getStatus(),
	            busId, nextStop,
	            nextStop, eta
	    );
	}
	
	public List<BusStatusDTO> getAllBusStatus() {

	    List<BusStatusDTO> result =
	            new ArrayList<>();

	    for (Bus bus :
	            busFleetService.getBusFleet()) {

	        BusStatusDTO status =
	                new BusStatusDTO();

	        status.setBusId(bus.getId());

	        status.setLatitude(
	                bus.getLatitude()
	        );

	        status.setLongitude(
	                bus.getLongitude()
	        );

	        status.setSpeed(
	                bus.getSpeed()
	        );

	        status.setNextStop(
	                etaService.getNextStop(bus)
	        );

	        status.setDistanceKm(
	                etaService
	                    .calculateDistanceToNextStop(bus)
	        );

	        status.setEtaMinutes(
	                etaService
	                    .calculateEtaMinutes(bus)
	        );

	        status.setStatus(
	        	    etaService.calculateStatus(bus)
	        	);

	        result.add(status);
	    }

	    return result;
	}

}