package com.bus.tracker.model;

import java.util.List;

public class Route {
	private int routeId;
	private List<Stop> stops;

	public Route(int routeId, List<Stop> stops) {
		super();
		this.routeId = routeId;
		this.stops = stops;
	}

	public int getRouteId() {
		return routeId;
	}

	public void setRouteId(int routeId) {
		this.routeId = routeId;
	}

	public List<Stop> getStops() {
		return stops;
	}

	public void setStops(List<Stop> stops) {
		this.stops = stops;
	}

}
