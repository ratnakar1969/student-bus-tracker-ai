package com.bus.tracker.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bus.tracker.entity.Parent;
import com.bus.tracker.model.Parents;
import com.bus.tracker.repository.ParentRepository;

@Service
public class ParentService {
	
	@Autowired	
	ParentRepository parentRepository;
	
    public ParentService() {}

       
    
    public Parents getParent(long parentId) {

       return parentRepository.findById(parentId).orElse(null);
    }

    public List<Parents> getParents() {
        return parentRepository.findAll();
    }


}
