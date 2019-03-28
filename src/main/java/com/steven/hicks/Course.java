package com.steven.hicks;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Course
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String schoolId;
    private String courseCode = "";
    private String courseName = "";
    private String grade = "";
    private int year;
    private String schoolYear = "";
    private Seasons season;


    public long getId()
    {
        return id;
    }

    public void setId(long id)
    {
        this.id = id;
    }

    public String getSchoolId()
    {
        return schoolId;
    }

    public void setSchoolId(String schoolId)
    {
        this.schoolId = schoolId;
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
}
