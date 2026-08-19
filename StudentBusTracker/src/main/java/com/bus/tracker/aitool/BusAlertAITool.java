package com.bus.tracker.aitool;

import java.util.List;

import org.springframework.ai.tool.annotation.Tool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bus.tracker.dto.ChildArrivalDTO;
import com.bus.tracker.dto.ParentBusAlertDTO;
import com.bus.tracker.dto.ParentBusStatusDTO;
import com.bus.tracker.service.BusAlertService;

@Component
public class BusAlertAITool {
	@Autowired
	private BusAlertService busAlertService;

	@Tool(description = """
			Check whether any buses belonging to the current parent's
			children are delayed. Use this when a parent asks whether
			any of their children are running late or whether any of
			their children's buses are delayed.
			""")
	public List<ParentBusAlertDTO> getMyDelayedBuses() {

		return busAlertService.getMyDelayedBuses();
	}
	
	  @Tool(description = """
	            Get the current bus status of all children belonging
	            to the current parent. Use this when a parent asks
	            about the locations, status, next stop or ETA of
	            their children.
	            """)
	    public List<ParentBusStatusDTO> getMyChildrenBusStatus() {

	        return busAlertService.getMyChildrenBusStatus();
	    }
	  
	  @Tool(description = """
		        Find which of the current parent's children is expected
		        to reach school first. Use this when a parent asks which
		        child will arrive first or which child's bus will reach
		        school first.
		        """)
		public ChildArrivalDTO getChildReachingFirst() {

		    return busAlertService.getChildReachingFirst();
		}


}
