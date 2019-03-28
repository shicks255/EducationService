package com.steven.hicks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService implements ICourseService
{
    @Autowired
    private CourseRepository courseRepo;

    @Override
    public List<Course> findAll()
    {
        return (List<Course>)courseRepo.findAll();
    }

    public void save(Course course)
    {
        courseRepo.save(course);
    }

}
