package com.steven.hicks.controllers;

import com.steven.hicks.entities.School;
import com.steven.hicks.exceptions.EntityNotFoundException;
import com.steven.hicks.repositories.SchoolService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public School getSchool(@PathVariable String acronim) throws EntityNotFoundException
    {

        School school = m_schoolService.getByAcronim(acronim);
        if (school == null)
            throw new EntityNotFoundException("School not found.");

        return school;
    }

    @GetMapping("")
    public List<School> getAllSchools()
    {
        return m_schoolService.findAll();
    }

}
