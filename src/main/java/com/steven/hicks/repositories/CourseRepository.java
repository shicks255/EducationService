package com.steven.hicks.repositories;

import com.steven.hicks.entities.Course;
import com.steven.hicks.entities.CourseId;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends CrudRepository<Course, CourseId>
{

}
