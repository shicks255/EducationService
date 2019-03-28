package com.steven.hicks;

import org.springframework.data.annotation.Id;

public class Semester
{
    @Id
    public long id;

    private String schoolYear = "";
    private int year;
    private String name = "";
    private int sequence;

}
