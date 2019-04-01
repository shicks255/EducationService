package com.steven.hicks.controllers;

import com.steven.hicks.entities.Course;
import com.steven.hicks.repositories.CourseService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
@RequestMapping("/course")
public class CourseController
{
    public CourseService m_courseService;

    public CourseController(CourseService service)
    {
        this.m_courseService = service;
    }

    @RequestMapping(method = RequestMethod.GET, value = "")
    public Course getCourse(@RequestParam(name = "id")Long id)
    {
        Course course = m_courseService.getById(id);
        if (course != null)
            return course;

        return null;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/search")
    public List<Course> searchCourses()
    {
        List<Course> courseList = m_courseService.findAll();
        return courseList;
    }

}
