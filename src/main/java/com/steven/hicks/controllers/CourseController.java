package com.steven.hicks.controllers;

import com.steven.hicks.entities.Course;
import com.steven.hicks.entities.CourseId;
import com.steven.hicks.entities.School;
import com.steven.hicks.entities.Seasons;
import com.steven.hicks.repositories.CourseService;
import com.steven.hicks.repositories.SchoolService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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

    @GetMapping("/{courseId}")
    @ApiOperation(value = "Get course by courseId")
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

    @GetMapping("")
    public List<Course> getAllCourses()
    {
        return m_courseService.findAll();
    }

    @PostMapping("")
    public Course addCourse(@RequestBody Map<String, Object> [] courseData)
    {
        for (Map<String, Object> course : courseData)
        {
            Course newCourse = new Course();
            CourseId courseId = new CourseId();
            courseId.setCourseCode("" + course.get("courseCode"));
            newCourse.setCourseName("" + course.get("courseName"));
            newCourse.setGrade("" + course.get("grade"));

            String semester = "" + course.get("semester");
            int year = Integer.parseInt(semester.substring(0,4));
            courseId.setYear(year);
            String season = semester.substring(4);

            if (season.equals("Spring"))
                courseId.setSeason(Seasons.SPRING);
            if (season.equals("Winter"))
                courseId.setSeason(Seasons.WINTER);
            if (season.equals("Fall"))
                courseId.setSeason(Seasons.FALL);
            if (season.equals("Summer"))
                courseId.setSeason(Seasons.SUMMER);


            newCourse.setCourseId(courseId);
            School school = m_schoolService.getByAcronim("" + course.get("school"));
            if (school != null)
                newCourse.setSchool(school);

            m_courseService.save(newCourse);

            return newCourse;
        }

        return null;
    }

}
