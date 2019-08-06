package com.steven.hicks.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class CourseId implements Serializable
{
    @Column
    private int year;

    @Column
    private Seasons season;

    @Column
    private String courseCode = "";

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CourseId courseId = (CourseId) o;
        return year == courseId.year &&
                season == courseId.season &&
                courseCode.equals(courseId.courseCode);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(year, season, courseCode);
    }

    public int getYear()
    {
        return year;
    }

    public void setYear(int year)
    {
        this.year = year;
    }

    public Seasons getSeason()
    {
        return season;
    }

    public void setSeason(Seasons season)
    {
        this.season = season;
    }

    public String getCourseCode()
    {
        return courseCode;
    }

    public void setCourseCode(String courseCode)
    {
        this.courseCode = courseCode;
    }
}
