package com.bus.tracker.dto;

public class BusStatusDTO {
	private int busId;

	private double latitude;
	private double longitude;

	private double speed;

	private String nextStop;

	private double distanceKm;

	private double etaMinutes;

	private String status;

	public BusStatusDTO() {

	}

	public BusStatusDTO(int busId, double latitude, double longitude, double speed, String nextStop, double distanceKm,
			double etaMinutes, String status) {
		super();
		this.busId = busId;
		this.latitude = latitude;
		this.longitude = longitude;
		this.speed = speed;
		this.nextStop = nextStop;
		this.distanceKm = distanceKm;
		this.etaMinutes = etaMinutes;
		this.status = status;
	}

	public int getBusId() {
		return busId;
	}

	public void setBusId(int busId) {
		this.busId = busId;
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

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}

	public String getNextStop() {
		return nextStop;
	}

	public void setNextStop(String nextStop) {
		this.nextStop = nextStop;
	}

	public double getDistanceKm() {
		return distanceKm;
	}

	public void setDistanceKm(double distanceKm) {
		this.distanceKm = distanceKm;
	}

	public double getEtaMinutes() {
		return etaMinutes;
	}

	public void setEtaMinutes(double etaMinutes) {
		this.etaMinutes = etaMinutes;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
