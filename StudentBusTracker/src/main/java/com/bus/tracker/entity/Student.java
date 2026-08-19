package com.bus.tracker.entity;

public class Student {
	   private int id;
	    private String name;
	    private int busId;

	    public Student() {
	    }

	    public Student(int id, String name, int busId) {
	        this.id = id;
	        this.name = name;
	        this.busId = busId;
	    }

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getBusId() {
			return busId;
		}

		public void setBusId(int busId) {
			this.busId = busId;
		}

}
