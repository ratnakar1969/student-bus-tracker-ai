package com.bus.tracker.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "buses")
public class Buses {

    @Id
    private Long id;

    @ManyToOne
    @JoinColumn(name = "route_id", nullable = false)
    private Routes route;

    private double speed;

    @Column(nullable = false)
    private String status;
    
    @Column(nullable = false, unique = true)
    private int busNumber;

    public Buses() {
    }

	public Buses(Long id, Routes route, double speed, String status) {
		super();
		this.id = id;
		this.route = route;
		this.speed = speed;
		this.status = status;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Routes getRoute() {
		return route;
	}

	public void setRoute(Routes route) {
		this.route = route;
	}

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getBusNumber() {
		return busNumber;
	}

	public void setBusNumber(int busNumber) {
		this.busNumber = busNumber;
	}

}
