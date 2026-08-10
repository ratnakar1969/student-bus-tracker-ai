package com.bus.tracker.dto;

public class ParentBusStatusDTO {
    private int busId;

    private String status;

    private String nextStop;

    private double etaMinutes;


    public ParentBusStatusDTO() {
    }





	public int getBusId() {
		return busId;
	}


	public void setBusId(int busId) {
		this.busId = busId;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public String getNextStop() {
		return nextStop;
	}


	public void setNextStop(String nextStop) {
		this.nextStop = nextStop;
	}


	public double getEtaMinutes() {
		return etaMinutes;
	}


	public void setEtaMinutes(double etaMinutes) {
		this.etaMinutes = etaMinutes;
	}





	public ParentBusStatusDTO(int busId, String status, String nextStop, double etaMinutes) {
		super();
		this.busId = busId;
		this.status = status;
		this.nextStop = nextStop;
		this.etaMinutes = etaMinutes;
	}

}
