package com.steven.hicks.controllers;

import com.steven.hicks.entities.Course;
import com.steven.hicks.repositories.CourseService;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{courseId}")
    public Course getCourse(@PathVariable(name = "courseId")Long id)
    {
        Course course = m_courseService.getById(id);
        if (course != null)
            return course;

        return null;
    }

    @GetMapping(value = "/search")
    public List<Course> searchCourses()
    {
        List<Course> courseList = m_courseService.findAll();
        return courseList;
    }

}
