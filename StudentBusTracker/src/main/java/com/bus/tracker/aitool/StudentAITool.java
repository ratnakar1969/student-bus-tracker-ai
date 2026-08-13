package com.bus.tracker.aitool;

import org.springframework.ai.tool.annotation.Tool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bus.tracker.model.Student;
import com.bus.tracker.service.StudentService;





@Component
public class StudentAITool {

    @Autowired
    private StudentService studentService;
    
    @Tool(description = """
            Get complete information about a student.Always use this tool when the user asks about a student or wants to know which bus
            is assigned to a student.
            """)
    public String getStudent(int studentId) {
    	 Student student = studentService.getStudent(studentId);

    	 if (student == null) {
    	        return "Student with ID " + studentId + " was not found.";
    	    }

    	    return "Student ID: " + student.getId()
    	            + ", Student Name: " + student.getName()
    	            + ", Assigned Bus Number: " + student.getBusId();
    }
    
    

    @Tool(description = """
            Find a student using their name.
            Returns the student's student ID and assigned bus number.
            Use this when the user refers to a student by name.
            """)
    public String getStudentByName(String name) {

        Student student = studentService.getStudentByName(name);

        if (student == null) {
            return "Student named " + name + " was not found.";
        }

        return "Student ID: " + student.getId()
                + ", Student Name: " + student.getName()
                + ", Assigned Bus Number: " + student.getBusId();
    }

}
