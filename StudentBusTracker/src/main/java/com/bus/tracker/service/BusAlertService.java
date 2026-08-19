package com.bus.tracker.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bus.tracker.context.ParentContext;
import com.bus.tracker.dto.BusStatusDTO;
import com.bus.tracker.dto.ChildArrivalDTO;
import com.bus.tracker.dto.ParentBusAlertDTO;
import com.bus.tracker.dto.ParentBusStatusDTO;
import com.bus.tracker.entity.Bus;
import com.bus.tracker.model.Buses;
import com.bus.tracker.model.Parents;
import com.bus.tracker.model.Students;

@Service
public class BusAlertService {


	@Autowired
	private BusMovementService busMovementService;

	@Autowired
	private ParentService parentService;

	@Autowired
	private StudentService studentService;
	
	 @Autowired
	 private ParentContext parentContextService;
	 
	 @Autowired
	 private BusAssignmentService busAssignmentService;
	 
	 @Autowired
	 private BusSimulationService busSimulationService;
	 
	 public ChildArrivalDTO getChildReachingFirst() {

		    List<ParentBusStatusDTO> children =
		            getMyChildrenBusStatus();

		    if (children.isEmpty()) {
		        return null;
		    }

		    ParentBusStatusDTO first =
		            children.get(0);

		    for (ParentBusStatusDTO child : children) {

		        if (child.getEtaMinutes()
		                < first.getEtaMinutes()) {

		            first = child;
		        }
		    }

		    return new ChildArrivalDTO(
		            first.getStudentId(),
		            first.getStudentName(),
		            first.getBusId(),
		            first.getEtaMinutes()
		    );
		}


	 public List<ParentBusAlertDTO> getMyDelayedBuses() {

		    List<ParentBusAlertDTO> delayedBuses =
		            new ArrayList<>();

		    int parentId =
		            parentContextService.getCurrentParentId();
		    
		    Parents parent =parentService.getParent(parentId);

		     if (parent == null) {
		        return delayedBuses;
		    }
		     
		    
		     List<Students> students = studentService.getStudents();
		     
		     for(Students student: students)
		     {
		    	 if(student.getParent().getId() == parentId)
		    	 {
		    		 Buses bus=busAssignmentService.getBusAssignmentByStudentId(student.getId());
		            if (bus == null) {
				            continue;
				        }
		            Bus simulationBus =
		                    busSimulationService.getBusByNumber(bus.getBusNumber());

		            if (simulationBus == null) {
		                continue;
		            }

		            BusStatusDTO status =
		                    busMovementService.getBusStatus(simulationBus);
				        if ("DELAYED".equalsIgnoreCase(
				                status.getStatus())) {

				            ParentBusAlertDTO alert =new ParentBusAlertDTO();
				            alert.setStudentId(student.getId().intValue());
				            alert.setEtaMinutes(status.getEtaMinutes());
				            alert.setNextStop(status.getNextStop());
				            alert.setStatus(status.getStatus());
				            alert.setStudentId(student.getId().intValue());
				            alert.setStudentName(student.getName());	            
				                    
    			            delayedBuses.add(alert);
				        }
		    	 }
		    	 
		    	 
		     }
		    

		    return delayedBuses;
		}
	 
	 public List<ParentBusStatusDTO> getMyChildrenBusStatus() {

		    List<ParentBusStatusDTO> result =
		            new ArrayList<>();

		    int parentId =
		            parentContextService.getCurrentParentId();
		    System.out.println("Current Parent Id = " + parentId);

		    Parents parent =
		            parentService.getParent(parentId);
		    System.out.println("Parent found " + parent);

		    if (parent == null) {
		        return result;
		    }
		    
     List<Students> students = studentService.getStudents();
		     
		     for(Students student: students)
		     {
		    	 System.out.println("Student = " + student.getName());
		    	 System.out.println("Student Parent Id = "
		    	         + student.getParent().getId());
		    	 if(student.getParent().getId() == parentId)
		    	 {
		    		  System.out.println(
		                      " Student belongs to current parent"
		              );
		    		 Buses bus=busAssignmentService.getBusAssignmentByStudentId(student.getId());
		    		  System.out.println(
		                      " Assigned DB Bus = " +
		                      (bus == null
		                              ? "NULL"
		                              : bus.getId())
		              );
		            if (bus == null) {
				            continue;
				        }
		            Bus simulationBus =
		                    busSimulationService.getBusByNumber(
		                            bus.getBusNumber()
		                    );
		            System.out.println("Simulation Bus = "
		                    + (simulationBus == null ? "NULL" : simulationBus.getId()));

		            if (simulationBus == null) {
		                continue;
		            }

		            BusStatusDTO status =
		                    busMovementService.getBusStatus(simulationBus);
				        ParentBusStatusDTO childStatus = new ParentBusStatusDTO();
				        childStatus.setStudentId(student.getId().intValue());
				        childStatus.setStudentName(student.getName());
				        childStatus.setEtaMinutes(status.getEtaMinutes());
				        childStatus.setNextStop(status.getNextStop());
				        childStatus.setStatus(status.getStatus());
				        childStatus.setBusId(status.getBusId());
				        result.add(childStatus);
		    	 }
		    	 
		    	 
		     }		    

		     System.out.println(
		             " Final result size = " +
		             result.size());
       return result;
		}

}
