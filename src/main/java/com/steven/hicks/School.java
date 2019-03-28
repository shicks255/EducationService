package com.steven.hicks;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class School
{
    @Id
    private String acronim = "";
    private String fullName = "";
}
