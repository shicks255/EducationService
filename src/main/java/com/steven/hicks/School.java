package com.steven.hicks;


import org.springframework.data.annotation.Id;

public class School
{
    @Id
    private int id;

    private String fullName = "";
    private String acronim = "";
}
