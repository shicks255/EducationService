package com.steven.hicks;

import org.springframework.data.annotation.Id;

public class Course
{
    @Id
    private long id;

    private int schoolId;
    private String courseCode = "";
    private String courseName = "";
    private String grade = "";



}
