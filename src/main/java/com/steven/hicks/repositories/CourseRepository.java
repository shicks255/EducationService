package com.steven.hicks.repositories;

import com.steven.hicks.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long>
{
    Course findByCourseIdYearAndCourseIdSeasonAndCourseIdCourseCode(int year, int season, String courseCode);

    @Query(value = "select c FROM COURSE c where c.season = ?1", nativeQuery = true)
    List<Course> find(Integer season);
}
