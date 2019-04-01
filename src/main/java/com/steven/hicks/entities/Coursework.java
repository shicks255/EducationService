package com.steven.hicks.entities;

import javax.persistence.*;

@Entity
public class Coursework
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne(fetch = FetchType.EAGER)
    private Course course;
    private String name = "";
    private String description = "";
}
