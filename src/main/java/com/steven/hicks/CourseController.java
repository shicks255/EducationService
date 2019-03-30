package com.steven.hicks;

import com.fasterxml.jackson.databind.ObjectMapper;
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
    public ObjectMapper  m_objectMapper;

    public CourseController(CourseService service, ObjectMapper mapper)
    {
        this.m_objectMapper = mapper;
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
