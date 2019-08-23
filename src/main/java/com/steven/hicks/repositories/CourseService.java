package com.steven.hicks.repositories;

import com.steven.hicks.entities.Course;
import com.steven.hicks.entities.CourseId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CourseService
{
    private CourseRepository courseRepo;

    @Autowired
    public CourseService(CourseRepository repo)
    {
        courseRepo = repo;
    }

    public Page<Course> findAll(Pageable pageable)
    {
        return courseRepo.findAll(pageable);
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
