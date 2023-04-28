package com.example.controller;

import com.example.dto.GroupDto;
import com.example.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class GroupController {
    @Autowired
    private GroupService groupService;

    @GetMapping("/groups")
    public List<GroupDto> findAll() {
        return groupService.findAll();
    }
}