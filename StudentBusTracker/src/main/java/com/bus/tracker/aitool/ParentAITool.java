package com.bus.tracker.aitool;

import java.util.List;

import org.springframework.ai.tool.annotation.Tool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bus.tracker.context.ParentContext;
import com.bus.tracker.dto.BusStatusDTO;
import com.bus.tracker.entity.Bus;
import com.bus.tracker.model.Buses;
import com.bus.tracker.model.Parents;
import com.bus.tracker.model.Students;
import com.bus.tracker.service.BusAssignmentService;
import com.bus.tracker.service.BusMovementService;
import com.bus.tracker.service.BusSimulationService;
import com.bus.tracker.service.ParentService;
import com.bus.tracker.service.StudentService;

@Component
public class ParentAITool {
	@Autowired
    private ParentService parentService;

    @Autowired
    private StudentService studentService;
    
    @Autowired
    private BusMovementService busMovementService;
    
    @Autowired
    private BusAssignmentService busAssignmentService;
    
    @Autowired
    private BusSimulationService busSimulationService;
    
        
    @Autowired
    private ParentContext parentContextService;

    @Tool(description = """
            Get the children belonging to the currently authenticated parent
            and the current status of their assigned buses.
            Use this when the parent asks about their children or their
            children's buses.
            Do not use this tool to access another parent's children.
            """)
    public String getParentStudents() {

    	int parentId = parentContextService.getCurrentParentId();
        Parents parent = parentService.getParent(parentId);
        
        

        if (parent == null) {
            return "Parent with ID " + parentId + " was not found.";
        }
        
      

        StringBuilder result = new StringBuilder();

        result.append("Parent: ")
              .append(parent.getName())
              .append("\n");
        
        List<Students> studentList =studentService.getStudentByParentId((long) parentId);
      

        for (Students student: studentList) {


            if (student != null) {
            	
            	Buses buses=busAssignmentService.getBusAssignmentByStudentId(student.getId());
            	Bus bus=busSimulationService.getBusByNumber(buses.getId().intValue());

            	  BusStatusDTO busStatus =
                          busMovementService.getBusStatus(bus);

                  result.append("Student ID: ")
                        .append(student.getId())
                        .append(", Student Name: ")
                        .append(student.getName())
                        .append(", Bus Number: ")
                        .append(bus.getId())
                        .append(", Status: ")
                        .append(busStatus.getStatus())
                        .append(", Next Stop: ")
                        .append(busStatus.getNextStop())
                        .append(", ETA Minutes: ")
                        .append(busStatus.getEtaMinutes())
                        .append("\n");
            }
        }

        return result.toString();
    }

}
