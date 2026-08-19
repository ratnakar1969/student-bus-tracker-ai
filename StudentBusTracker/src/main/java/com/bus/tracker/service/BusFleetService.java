package com.bus.tracker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bus.tracker.builder.BuildBusFleet;
import com.bus.tracker.entity.Bus;

@Service
public class BusFleetService {

	@Autowired
	BuildBusFleet buildBusFleet;

	public List<Bus> getBusFleet() {
		return buildBusFleet.createBuses();
	}

	public Bus getBus(int id) {
		List<Bus> buses = getBusFleet();

		for (Bus bus : buses) {

			if (bus.getId() == id) {
				return bus;
			}
		}

		return null;
	}

}
