package com.steven.hicks.controllers;

import com.steven.hicks.entities.*;
import com.steven.hicks.exceptions.EntityNotFoundException;
import com.steven.hicks.repositories.CourseService;
import com.steven.hicks.repositories.SchoolService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController()
@RequestMapping("/course")
@CrossOrigin
@Api(value = "Course", tags = {"Course"})
public class CourseController
{
    public CourseService m_courseService;
    public SchoolService m_schoolService;

    @Autowired
    public CourseController(CourseService service, SchoolService schoolService)
    {
        this.m_courseService = service;
        this.m_schoolService = schoolService;
    }

    @GetMapping("/course")
    @ApiOperation(value = "Get course by courseId", notes = "Seasons are: </br>Winter - 0 <br/>Spring - 1 <br/> Summer - 2 <br/> Fall - 3")
    public Course getCourse(
            @RequestParam(name = "year") int year,
            @RequestParam(name = "season") int season,
            @RequestParam(name = "courseCode") String courseCode) throws EntityNotFoundException
    {
        CourseId id = new CourseId();
        id.setYear(year);
        id.setSeason(Seasons.getSeasonsFromValue(season));
        id.setCourseCode(courseCode);

        Course course = m_courseService.getById(id);
        if (course == null)
            throw new EntityNotFoundException("Course not found");

        return course;
    }

    @GetMapping("")
    public List<Course> getAllCourses(
            @RequestParam(name = "Page", required = true) int page,
            @RequestParam(name = "Size", required = true) int size,
            @RequestParam(name = "Course Code", required = false) String courseCode,
            @RequestParam(name = "Season", required = false) Integer season,
            @RequestParam(name = "Year", required = false) Integer year,
            @RequestParam(name = "Name", required = false) String courseName,
            @RequestParam(name = "Grade", required = false) String grade,
            @RequestParam(name = "School", required = false) String school)
    {
        Pageable pageable = new PageRequest(page, size, Sort.by("grade"));
        Page<Course> courses =  m_courseService.findAll(pageable);

        List<Course> courseList = courses.stream().filter(x -> {
            CourseId id = x.getCourseId();
            if (courseCode != null)
                if (!courseCode.equalsIgnoreCase(id.getCourseCode()))
                    return false;
            if (season != null)
                if (id.getSeason().getSeq() != season)
                    return false;
            if (year != null)
                if (id.getYear() != year)
                    return false;
            if (courseName != null)
                if (!courseName.equalsIgnoreCase(x.getCourseName()))
                    return false;
            if (grade != null)
                if (!x.getGrade().equalsIgnoreCase(grade))
                    return false;
            if (school != null)
                if (!x.getSchool().getAcronim().equalsIgnoreCase(school))
                    return false;

            return true;
        }).collect(Collectors.toList());

        return courseList;
    }

    @PostMapping("")
    @ApiOperation(value = "addCourse", response = CourseDTO.class)
    public Course addCourse(@RequestBody CourseDTO courseData)
    {
        Course newCourse = new Course();
        CourseId courseId = new CourseId();
        courseId.setCourseCode(courseData.getCourseCode());
        newCourse.setCourseName(courseData.getCourseName());
        newCourse.setGrade(courseData.getGrade());

        Integer season = courseData.getSeasonCode();
        courseId.setSeason(Seasons.getSeasonsFromValue(season));
        Integer year = courseData.getYear();
        courseId.setYear(year);

        newCourse.setCourseId(courseId);
        School school = m_schoolService.getByAcronim(courseData.getSchool());
        if (school != null)
            newCourse.setSchool(school);

        m_courseService.save(newCourse);

        return newCourse;
    }

}
