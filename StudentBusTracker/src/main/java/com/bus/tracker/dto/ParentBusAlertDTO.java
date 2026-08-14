package com.bus.tracker.dto;

public class ParentBusAlertDTO {
	

    private int studentId;
    private String studentName;
    private int busId;
    private String status;
    private String nextStop;
    private double etaMinutes;

    public ParentBusAlertDTO() {
    }

	public ParentBusAlertDTO(int studentId, String studentName, int busId, String status, String nextStop,
			double etaMinutes) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.busId = busId;
		this.status = status;
		this.nextStop = nextStop;
		this.etaMinutes = etaMinutes;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
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

}
