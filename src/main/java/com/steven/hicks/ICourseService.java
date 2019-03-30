package com.steven.hicks;

import java.util.List;

public interface ICourseService
{
    List<Course> findAll();
    void save(Course course);
    Course getById(Long id);
}
