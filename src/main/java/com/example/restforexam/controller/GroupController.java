package com.example.restforexam.controller;

import com.example.restforexam.model.Group;
import com.example.restforexam.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GroupController {
    private GroupService groupService;

    @Autowired
    public void setGroupService(GroupService groupService) {
        this.groupService = groupService;
    }

    @GetMapping("/groups")
    public Iterable<Group> getGroups() {
        return groupService.getAlGroups();
    }

    @GetMapping("/groups/{code}")
    public Group getByCode(@PathVariable String code) {
        return groupService.getGroupByCode(code);
    }

    @GetMapping("/groups/random")
    public Group getRandom() {
        return groupService.getRandomGroup();
    }
}
