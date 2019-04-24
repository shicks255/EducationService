package com.steven.hicks;

import com.steven.hicks.entities.School;
import com.steven.hicks.repositories.CourseService;
import com.steven.hicks.repositories.CourseworkService;
import com.steven.hicks.repositories.SchoolService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class DatabaseTask
{
    @Bean
    public CommandLineRunner createDatabase(CourseService courseService, SchoolService schoolService, CourseworkService courseworkService)
    {
        return args -> {
            System.out.println("Setting up dummy data");

            School rvcc = new School();
            rvcc.setAcronim("RVCC");
            rvcc.setFullName("Raritan Valley Community College");
            schoolService.save(rvcc);

            School rsc = new School();
            rsc.setAcronim("RSC");
            rsc.setFullName("Richard Stockton College");
            schoolService.save(rsc);

            System.out.println("Demo data created");
        };
    }
}
