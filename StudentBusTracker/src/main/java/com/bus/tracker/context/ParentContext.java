package com.bus.tracker.context;

import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.RequestScope;

@Service
@RequestScope
public class ParentContext {
	  private int parentId;
	  
	  private int currentParentId = 1;

	


	    public int getParentId() {
	        return parentId;
	    }
	    
	    public int getCurrentParentId() {
	        return currentParentId;
	    }

	    public void setCurrentParentId(int parentId) {
	        this.currentParentId = parentId;
	    }

}
