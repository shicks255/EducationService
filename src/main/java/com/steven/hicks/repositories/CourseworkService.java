package com.steven.hicks.repositories;

import com.steven.hicks.entities.Coursework;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseworkService
{
    private CourseworkRepository repo;

    @Autowired
    public CourseworkService(CourseworkRepository repo)
    {
        this.repo = repo;
    }

    public List<Coursework> findAll()
    {
        return (List<Coursework>)repo.findAll();
    }

    public void save(Coursework course)
    {
        repo.save(course);
    }

    public Coursework getById(Long id)
    {
        return repo.findById(id).orElse(null);
    }

}
