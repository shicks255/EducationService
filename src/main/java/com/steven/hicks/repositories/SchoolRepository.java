package com.steven.hicks.repositories;

import com.steven.hicks.entities.School;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SchoolRepository extends CrudRepository<School, String>
{
}
