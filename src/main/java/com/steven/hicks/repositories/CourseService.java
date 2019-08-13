package com.steven.hicks.repositories;

import com.steven.hicks.entities.Course;
import com.steven.hicks.entities.CourseId;
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

    public Course getById(CourseId id)
    {
        return courseRepo.findById(id).orElse(null);
    }
}
