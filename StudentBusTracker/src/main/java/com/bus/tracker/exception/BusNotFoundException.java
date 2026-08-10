package com.bus.tracker.exception;


public class BusNotFoundException extends RuntimeException {
	
	   public BusNotFoundException(int busId) {
	        super("Bus " + busId + " not found");
	    }

}
