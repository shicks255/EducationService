package com.steven.hicks.controllers;

import com.steven.hicks.entities.School;
import com.steven.hicks.repositories.SchoolService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/school")
@Api(value = "School", tags = {"School"})
public class SchoolController
{
    private SchoolService m_schoolService;

    @Autowired
    public SchoolController(SchoolService schoolService)
    {
        this.m_schoolService = schoolService;
    }

    @GetMapping("/{acronim}")
    @ApiOperation(value = "Get school by school Acronim", notes = "acronyms are case sensitive")
    public School getSchool(@PathVariable String acronim)
    {
        School school = m_schoolService.getByAcronim(acronim);
        return school;
    }

    @GetMapping("")
    public List<School> getAllSchools()
    {
        return m_schoolService.findAll();
    }

}
