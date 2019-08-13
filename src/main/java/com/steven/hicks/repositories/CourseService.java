package com.steven.hicks.repositories;

import com.steven.hicks.entities.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService
{
    private CourseRepository courseRepo;

    @Autowired
    public CourseService(CourseRepository repo)
    {
        courseRepo = repo;
    }

    public List<Course> findAll()
    {
        return (List<Course>)courseRepo.findAll();
    }

    public void save(Course course)
    {
        courseRepo.save(course);
    }

    public Course getById(Long id)
    {
        return courseRepo.findById(id).orElse(null);
    }

    public Course getByYearAndSeasonAndCourseCode(int year, int season, String courseCode)
    {
        return courseRepo.findByCourseIdYearAndCourseIdSeasonAndCourseIdCourseCode(year, season, courseCode);
    }

    public List<Course> findBySeasons(int season)
    {
        return courseRepo.find(season);
    }
}
