package com.bus.tracker.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "bus_assignments")
public class BusAssignment {
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @ManyToOne
	    @JoinColumn(name = "student_id", nullable = false)
	    private Students student;

	    @ManyToOne
	    @JoinColumn(name = "bus_id", nullable = false)
	    private Buses bus;

	    public BusAssignment() {
	    }

		public BusAssignment(Students student, Buses bus) {
			super();
			this.student = student;
			this.bus = bus;
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public Students getStudent() {
			return student;
		}

		public void setStudent(Students student) {
			this.student = student;
		}

		public Buses getBus() {
			return bus;
		}

		public void setBus(Buses bus) {
			this.bus = bus;
		}
	    
	    

}
