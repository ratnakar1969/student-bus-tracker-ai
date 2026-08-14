package com.bus.tracker.dto;

public class ChildArrivalDTO {
    private int studentId;
    private String studentName;
    private int busId;
    private double etaMinutes;

    public ChildArrivalDTO() {
    }

	public ChildArrivalDTO(int studentId, String studentName, int busId, double etaMinutes) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.busId = busId;
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

	public double getEtaMinutes() {
		return etaMinutes;
	}

	public void setEtaMinutes(double etaMinutes) {
		this.etaMinutes = etaMinutes;
	}
    

}
