package com.steven.hicks.controllers;

import com.steven.hicks.entities.Coursework;
import com.steven.hicks.repositories.CourseworkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/coursework")
public class CourseworkController
{
    public CourseworkService m_courseworkService;

    public CourseworkController(CourseworkService courseworkService)
    {
        this.m_courseworkService = courseworkService;
    }

    @GetMapping("/{courseworkId}")
    public Coursework getCoursework(@PathVariable(name = "courseworkId")Long courseworkId)
    {
        Coursework coursework = m_courseworkService.getById(courseworkId);
        if (coursework != null)
            return coursework;

        return null;
    }


}
