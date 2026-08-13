package com.bus.tracker.model;

public class Bus {

    private int id;
    private Route route;
    private int currentStopIndex;
    private double latitude;
    private double longitude;
    private double speed;
    private String status;
    private double scheduledEtaMinutes;

    public Bus(int id, Route route, double speed, String status,double scheduledEtaMinutes) {

        this.id = id;
        this.route = route;
        this.currentStopIndex = 0;
        this.speed = speed;
        this.status = status;
        this.latitude =
                route.getStops().get(0).getLatitude();

        this.longitude =
                route.getStops().get(0).getLongitude();
        
        this.scheduledEtaMinutes = scheduledEtaMinutes;
    }

    public Bus() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
        return id;
    }

    public Route getRoute() {
        return route;
    }

    public double getSpeed() {
        return speed;
    }

    public String getStatus() {
        return status;
    }

    public String getCurrentLocation() {

        return route.getStops().get(currentStopIndex).getName();
    }

   

	public int getCurrentStopIndex() {
		return currentStopIndex;
	}

	public void setCurrentStopIndex(int currentStopIndex) {
		this.currentStopIndex = currentStopIndex;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setRoute(Route route) {
		this.route = route;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public double getScheduledEtaMinutes() {
		return scheduledEtaMinutes;
	}

	public void setScheduledEtaMinutes(double scheduledEtaMinutes) {
		this.scheduledEtaMinutes = scheduledEtaMinutes;
	}
	
}