package com.steven.hicks.repositories;

import com.steven.hicks.entities.Coursework;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseworkRepository extends CrudRepository<Coursework, Long>
{
}
