package com.bus.tracker.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.bus.tracker.entity.Student;

@Service
public class StudentService {
	private final List<Student> students = Arrays.asList(
            new Student(1, "Rahul", 37),
            new Student(2, "Priya", 40),
            new Student(3, "Arjun", 42)
    );

    public Student getStudent(int studentId) {

        for (Student student : students) {

            if (student.getId() == studentId) {
                return student;
            }
        }

        return null;
    }
    
    public Student getStudentByName(String name) {

        for (Student student : students) {

            if (student.getName().equalsIgnoreCase(name)) {
                return student;
            }
        }

        return null;
    }

}
