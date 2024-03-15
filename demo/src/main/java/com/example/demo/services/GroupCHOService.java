package com.example.demo.services;

import com.example.demo.classes.GroupCHO;
import com.example.demo.repositories.GroupCHORepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupCHOService {
    private final GroupCHORepository groupCHORepository;

    @Autowired
    public GroupCHOService(GroupCHORepository groupCHORepository) {
        this.groupCHORepository = groupCHORepository;
    }

    public List<GroupCHO> getCHOGroups() {
        return groupCHORepository.findAll();
    }
}
