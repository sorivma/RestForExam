package com.example.restforexam.service;

import com.example.restforexam.exception.EntityNotFoundException;
import com.example.restforexam.model.Group;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;
import java.util.Random;


@Service
public class GroupService {
    private final Map<String, Group> groups = Map.of(
            "УВП-313", Group.builder().code("УВП-313").studentCount(26).build(),
            "УВП-312", Group.builder().code("УВП-312").studentCount(26).build(),
            "УВП-311", Group.builder().code("УВП-311").studentCount(26).build()
    );

    public Group getGroupByCode(String code) {
        return Optional.ofNullable(groups.get(code)).orElseThrow(
                () -> new EntityNotFoundException("Группа", "Код группы", code)
        );
    }

    public Iterable<Group> getAlGroups() {
        return groups.values();
    }

    public Group getRandomGroup() {
        Random generator = new Random();
        return groups.entrySet()
                .stream()
                .toList()
                .get(generator.nextInt(groups.entrySet().size())).getValue();
    }
}
