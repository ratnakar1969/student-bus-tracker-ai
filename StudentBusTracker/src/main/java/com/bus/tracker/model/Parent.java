package com.bus.tracker.model;

import java.util.List;

public class Parent {
    private int id;
    private String name;
    private List<Integer> studentIds;

    public Parent() {
    }

    public Parent(int id, String name, List<Integer> studentIds) {
        this.id = id;
        this.name = name;
        this.studentIds = studentIds;
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

	public List<Integer> getStudentIds() {
		return studentIds;
	}

	public void setStudentIds(List<Integer> studentIds) {
		this.studentIds = studentIds;
	}

}
