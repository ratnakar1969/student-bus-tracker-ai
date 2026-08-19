package com.bus.tracker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bus.tracker.model.Buses;
import com.bus.tracker.repository.BusRepository;

@Service
public class BusFleetService {

    @Autowired
    private BusRepository busRepository;

    public List<Buses> getBusFleet() {
        return busRepository.findAll();
    }

    public Buses getBus(int id) {
        return busRepository.findById((long) id).orElse(null);
    }
    
    public Buses getBusByNumber(int busNumber) {

        return busRepository
                .findByBusNumber(busNumber)
                .orElse(null);
    }

}
