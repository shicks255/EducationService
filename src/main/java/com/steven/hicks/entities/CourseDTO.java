package com.steven.hicks.entities;

public class CourseDTO
{
    private Integer year;
    private Integer seasonCode;
    private String courseCode = "";
    private String school = "";
    private String courseName = "";
    private String grade = "";


    public Integer getYear()
    {
        return year;
    }

    public void setYear(Integer year)
    {
        this.year = year;
    }

    public Integer getSeasonCode()
    {
        return seasonCode;
    }

    public void setSeasonCode(Integer seasonCode)
    {
        this.seasonCode = seasonCode;
    }

    public String getCourseCode()
    {
        return courseCode;
    }

    public void setCourseCode(String courseCode)
    {
        this.courseCode = courseCode;
    }

    public String getSchool()
    {
        return school;
    }

    public void setSchool(String school)
    {
        this.school = school;
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
}
