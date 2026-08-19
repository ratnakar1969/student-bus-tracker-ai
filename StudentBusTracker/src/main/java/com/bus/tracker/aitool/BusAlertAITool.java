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
	        Check whether any buses belonging to the children of the
	        currently logged-in parent are delayed.

	        Use this when the parent asks:
	        - Is my child's bus delayed?
	        - Is my child’s bus running late?
	        - Are any of my children’s buses delayed?
	        - Are my children running late?

	        Do NOT ask the parent for their name or their child's name.
	        The current parent is already available through the parent
	        context.
	        """)
	public List<ParentBusAlertDTO> getMyDelayedBuses() {

		return busAlertService.getMyDelayedBuses();
	}
	
	@Tool(description = """
	        Get the current live bus status for the children of the
	        currently logged-in parent.

	        Use this tool when the parent asks:
	        - What is the status of my child's bus?
	        - Where is my child's bus?
	        - Where is my child’s bus?
	        - What is the location of my child's bus?
	        - What is the ETA of my child's bus?
	        - What is the next stop of my child's bus?
	        - What are my children's bus statuses?

	       Do NOT ask the parent for their name or their child's name.
        The current parent is already available through the parent
        context and this tool automatically determines which
        children and buses belong to that parent.
        """)
	    public List<ParentBusStatusDTO> getMyChildrenBusStatus() {

	        return busAlertService.getMyChildrenBusStatus();
	    }
	  
	@Tool(description = """
	        Determine which child of the currently logged-in parent
	        is expected to reach school first.

	        Use this when the parent asks:
	        - Which child will reach school first?
	        - Which of my children will arrive first?
	        - Whose bus will reach school first?

	        Do NOT ask the parent for their name or their child's name.
	        The current parent is already available through the parent
	        context.
	        """)
		public ChildArrivalDTO getChildReachingFirst() {

		    return busAlertService.getChildReachingFirst();
		}


}
