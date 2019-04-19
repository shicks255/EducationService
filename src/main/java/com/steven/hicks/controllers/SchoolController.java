package com.steven.hicks.controllers;

import com.steven.hicks.entities.School;
import com.steven.hicks.repositories.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@RestController
@RequestMapping("/school")
public class SchoolController
{
    private SchoolService schoolService;

    @Autowired
    public SchoolController(SchoolService schoolService)
    {
        this.schoolService = schoolService;
    }

    @GetMapping("/{acronim}")
    public School getSchool(@PathVariable String acronim)
    {
        School school = schoolService.getByAcronim(acronim);
        return school;
    }

}
