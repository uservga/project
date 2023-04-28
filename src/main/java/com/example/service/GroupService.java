package com.example.service;

import com.example.dto.GroupDto;
import com.example.entity.Group;
import com.example.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class GroupService {
    @Autowired
    private GroupRepository groupRepository;

    public List<GroupDto> findAll() {
        List<Group> groups = groupRepository.findAll();
        List<GroupDto> groupDTOs = new ArrayList<>();

        for (Group group : groups){
            GroupDto groupDTO = new GroupDto();
            groupDTO.setId(group.getId());
            groupDTO.setName(group.getNameGroup());
            groupDTOs.add(groupDTO);
        }
        return groupDTOs;
    }
}