package com.bus.tracker.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.bus.tracker.entity.Parent;

@Service
public class ParentService {
	
	private final List<Parent> parents = new ArrayList<>();
    public ParentService() {

        parents.add(
            new Parent(
                1,
                "Parent 1",
                Arrays.asList(1,2)
            )
        );

        parents.add(
            new Parent(
                2,
                "Parent 2",
                Arrays.asList(3)
            )
        );
    }
    public Parent getParent(int parentId) {

        for (Parent parent : parents) {

            if (parent.getId() == parentId) {
                return parent;
            }
        }

        return null;
    }

    public List<Parent> getParents() {
        return parents;
    }


}
