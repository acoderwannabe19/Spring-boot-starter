package com.example.demo.controllers;

import com.example.demo.classes.GroupCHO;
import com.example.demo.services.GroupCHOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/groupcho")
public class GroupCHOController {
    public final GroupCHOService groupCHOService;

    @Autowired
    public GroupCHOController(GroupCHOService groupCHOService) {
        this.groupCHOService = groupCHOService;
    }

    @GetMapping
    public List<GroupCHO> getCHOGroups() {return groupCHOService.getCHOGroups();}
}
