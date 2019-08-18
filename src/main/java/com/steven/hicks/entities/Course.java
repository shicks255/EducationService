package com.steven.hicks.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table
public class Course
{
    @EmbeddedId
    private CourseId courseId;

    @ManyToOne(fetch = FetchType.EAGER)
    private School school;
    private String courseName = "course";
    private String grade = "";

    @OneToMany(mappedBy = "")
//    @JsonIgnoreProperties("course")
    private List<Coursework> coursework = new ArrayList<>();

    @Override
    public String toString()
    {
        return String.format("%s - %s - %s", courseId.getCourseCode(), courseId.getSeason(), courseId.getYear());
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return courseId.equals(course.courseId);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(courseId);
    }

    public CourseId getCourseId()
    {
        return courseId;
    }

    public void setCourseId(CourseId courseId)
    {
        this.courseId = courseId;
    }

    public String getCourseName()
    {
        return courseName;
    }

    public void setCourseName(String courseName)
    {
        this.courseName = courseName;
    }

    public String getGrade()
    {
        return grade;
    }

    public void setGrade(String grade)
    {
        this.grade = grade;
    }

    public School getSchool()
    {
        return school;
    }

    public void setSchool(School school)
    {
        this.school = school;
    }

    public List<Coursework> getCoursework()
    {
        return coursework;
    }

    public void setCoursework(List<Coursework> coursework)
    {
        this.coursework = coursework;
    }
}
