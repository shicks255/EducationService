package com.steven.hicks.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
public class Coursework
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "year", referencedColumnName = "year"),
            @JoinColumn(name = "season", referencedColumnName = "season"),
            @JoinColumn(name = "courseCode", referencedColumnName = "courseCode")
    })
    @JsonIgnoreProperties("coursework")
    private Course course;
    private String name = "";
    private String description = "";

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

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }
}
