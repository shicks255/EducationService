package com.steven.hicks.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
public class Coursework
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumns({
            @JoinColumn(name = "year", referencedColumnName = "year"),
            @JoinColumn(name = "season", referencedColumnName = "season"),
            @JoinColumn(name = "courseCode", referencedColumnName = "courseCode")
    })
    @JsonBackReference
    private Course course;
    private String description = "";
    private String fileName = "";

    public long getId()
    {
        return id;
    }

    public void setId(long id)
    {
        this.id = id;
    }

    public Course getCourse()
    {
        return course;
    }

    public void setCourse(Course course)
    {
        this.course = course;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public String getFileName()
    {
        return fileName;
    }

    public void setFileName(String fileName)
    {
        this.fileName = fileName;
    }
}
