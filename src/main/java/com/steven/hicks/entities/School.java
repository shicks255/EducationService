package com.steven.hicks.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class School
{
    @Id
    private String acronim = "";
    private String fullName = "";

    public String getAcronim()
    {
        return acronim;
    }

    public void setAcronim(String acronim)
    {
        this.acronim = acronim;
    }

    public String getFullName()
    {
        return fullName;
    }

    public void setFullName(String fullName)
    {
        this.fullName = fullName;
    }

}
