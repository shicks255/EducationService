package com.steven.hicks.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Course
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne(fetch = FetchType.EAGER)
    private School school;
    private String courseCode = "";
    private String courseName = "";
    private String grade = "";
    private int year;
    private String schoolYear = "";
    private Seasons season;

    @OneToMany(mappedBy = "course")
    private List<Coursework> coursework = new ArrayList<>();

    @Override
    public String toString()
    {
        return String.format("%s - %s - %s - %s", id, courseCode, courseName, year);
    }


    public long getId()
    {
        return id;
    }

    public void setId(long id)
    {
        this.id = id;
    }

    public String getCourseCode()
    {
        return courseCode;
    }

    public void setCourseCode(String courseCode)
    {
        this.courseCode = courseCode;
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

    public int getYear()
    {
        return year;
    }

    public void setYear(int year)
    {
        this.year = year;
    }

    public String getSchoolYear()
    {
        return schoolYear;
    }

    public void setSchoolYear(String schoolYear)
    {
        this.schoolYear = schoolYear;
    }

    public Seasons getSeason()
    {
        return season;
    }

    public void setSeason(Seasons season)
    {
        this.season = season;
    }

    public School getSchool()
    {
        return school;
    }

    public void setSchool(School school)
    {
        this.school = school;
    }
}
