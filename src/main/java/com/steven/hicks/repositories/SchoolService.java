package com.steven.hicks.repositories;

import com.steven.hicks.entities.School;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchoolService
{
    private SchoolRepository repo;

    @Autowired
    public SchoolService(SchoolRepository repo)
    {
        this.repo = repo;
    }

    public List<School> findAll()
    {
        return (List<School>)repo.findAll();
    }

    public void save(School school)
    {
        repo.save(school);
    }

    public School getByAcronim(String acronim)
    {
        return repo.findByAcronimIgnoreCase(acronim).orElse(null);
    }

}
