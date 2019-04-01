package com.steven.hicks.controllers;

import com.steven.hicks.entities.School;
import com.steven.hicks.repositories.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("/")
    public School getSchool(@RequestParam(name="id")String id)
    {
        School school = schoolService.getByAcronim(id);
        return school;
    }

}
