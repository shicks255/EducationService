package com.steven.hicks;

import org.springframework.data.annotation.Id;

public class Coursework
{
    @Id
    private long id;

    private String name = "";
    private String description = "";
}
