package com.bus.tracker.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.bus.tracker.model.Parents;
import com.bus.tracker.model.Students;
import com.bus.tracker.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	StudentRepository studentRepository;
	
	public List<Students> getStudents() {
		return studentRepository.findAll();
	}

    public Students getStudent(Long studentId) {

          return studentRepository.findById(studentId).orElse(null);
    }
    
    public Students getStudentByName(String name) {

        return studentRepository.findByName(name);
    }
    
    public List<Students> getStudentByParentId(Long parentId)
    {
    	List<Students> students=new ArrayList<Students>();
    	        Parents parent= studentRepository.findByParentId(parentId);
				for (Students student : getStudents()) {
					if (student.getParent().getId() == parent.getId()) {
						students.add(student);
					}
				}
			return students;
    	        
    }

}
