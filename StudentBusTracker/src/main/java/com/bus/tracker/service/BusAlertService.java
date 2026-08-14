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
import com.bus.tracker.model.Bus;
import com.bus.tracker.model.Parent;
import com.bus.tracker.model.Student;

@Service
public class BusAlertService {
	@Autowired
	private BusFleetService busFleetService;

	@Autowired
	private BusMovementService busMovementService;

	@Autowired
	private ParentService parentService;

	@Autowired
	private StudentService studentService;
	
	 @Autowired
	 private ParentContext parentContextService;
	 
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

		    Parent parent =
		            parentService.getParent(parentId);

		    if (parent == null) {
		        return delayedBuses;
		    }

		    for (Integer studentId :
		            parent.getStudentIds()) {

		        Student student =
		                studentService.getStudent(studentId);

		        if (student == null) {
		            continue;
		        }

		        int busId = student.getBusId();

		        Bus bus =
		                busFleetService.getBus(busId);

		        if (bus == null) {
		            continue;
		        }
		        BusStatusDTO status =
		                busMovementService.getBusStatus(busId);
		      

		        if ("DELAYED".equalsIgnoreCase(
		                status.getStatus())) {

		            ParentBusAlertDTO alert =
		                    new ParentBusAlertDTO(
		                            student.getId(),
		                            student.getName(),
		                            busId,
		                            status.getStatus(),
		                            status.getNextStop(),
		                            status.getEtaMinutes()
		                    );

		            delayedBuses.add(alert);
		        }
		    }

		    return delayedBuses;
		}
	 
	 public List<ParentBusStatusDTO> getMyChildrenBusStatus() {

		    List<ParentBusStatusDTO> result =
		            new ArrayList<>();

		    int parentId =
		            parentContextService.getCurrentParentId();

		    Parent parent =
		            parentService.getParent(parentId);

		    if (parent == null) {
		        return result;
		    }

		    for (Integer studentId :
		            parent.getStudentIds()) {

		        Student student =
		                studentService.getStudent(studentId);

		        if (student == null) {
		            continue;
		        }

		        int busId = student.getBusId();

		        Bus bus =
		                busFleetService.getBus(busId);

		        if (bus == null) {
		            continue;
		        }

		        BusStatusDTO status =
		                busMovementService.getBusStatus(busId);

		        ParentBusStatusDTO childStatus =
		                new ParentBusStatusDTO(
		                        student.getId(),
		                        student.getName(),
		                        busId,
		                        status.getStatus(),
		                        status.getNextStop(),
		                        status.getEtaMinutes()
		                );
		        
	

		        result.add(childStatus);
		    }

		    return result;
		}

}
