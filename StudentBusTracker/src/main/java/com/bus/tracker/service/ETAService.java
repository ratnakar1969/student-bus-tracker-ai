package com.bus.tracker.service;

import org.springframework.stereotype.Service;

import com.bus.tracker.model.Bus;
import com.bus.tracker.model.Route;
import com.bus.tracker.model.Stop;

@Service
public class ETAService {
	
	public String calculateStatus(Bus bus) {

	    double actualEta =
	            calculateEtaMinutes(bus);

	    double scheduledEta =
	            bus.getScheduledEtaMinutes();

	    if (actualEta < 0) {
	        return "UNKNOWN";
	    }

	    if (actualEta > scheduledEta + 2) {
	        return "DELAYED";
	    }

	    return "ON TIME";
	}
	
	

    public double calculateDistanceToNextStop(Bus bus) {

        Route route = bus.getRoute();

        int currentIndex =
                bus.getCurrentStopIndex();

        // Already at final stop
        if (currentIndex >= route.getStops().size() - 1) {
            return 0.0;
        }

        Stop nextStop =
                route.getStops().get(currentIndex + 1);
		return calculateDistance(bus.getLatitude(), bus.getLongitude(), nextStop.getLatitude(),
				nextStop.getLongitude());

    
    }


    public double calculateEtaMinutes(Bus bus) {

        double distance =
                calculateDistanceToNextStop(bus);

        double speed = bus.getSpeed();

        if (speed <= 0) {
            return -1;
        }

        /*
         * Time = Distance / Speed
         *
         * Distance = kilometres
         * Speed = kilometres/hour
         *
         * Result = hours
         */

        double timeHours =
                distance / speed;

        return timeHours * 60;
    }


    public String getNextStop(Bus bus) {

        Route route = bus.getRoute();

        int currentIndex =
                bus.getCurrentStopIndex();

        if (currentIndex >= route.getStops().size() - 1) {
            return "School";
        }

        return route
                .getStops()
                .get(currentIndex + 1)
                .getName();
    }


    private double calculateDistance(
            double lat1,
            double lon1,
            double lat2,
            double lon2) {

        final double EARTH_RADIUS = 6371.0;

        double lat1Rad =
                Math.toRadians(lat1);

        double lat2Rad =
                Math.toRadians(lat2);

        double deltaLat =
                Math.toRadians(lat2 - lat1);

        double deltaLon =
                Math.toRadians(lon2 - lon1);

        double a =
                Math.sin(deltaLat / 2)
                * Math.sin(deltaLat / 2)
                +
                Math.cos(lat1Rad)
                * Math.cos(lat2Rad)
                * Math.sin(deltaLon / 2)
                * Math.sin(deltaLon / 2);

        double c =
                2 * Math.atan2(
                        Math.sqrt(a),
                        Math.sqrt(1 - a)
                );

        return EARTH_RADIUS * c;
    }
}