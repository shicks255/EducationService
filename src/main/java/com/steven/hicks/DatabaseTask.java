package com.steven.hicks;

import com.steven.hicks.entities.Course;
import com.steven.hicks.entities.School;
import com.steven.hicks.entities.Seasons;
import com.steven.hicks.repositories.CourseService;
import com.steven.hicks.repositories.SchoolService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class DatabaseTask
{
    @Bean
    public CommandLineRunner createDatabase(CourseService courseService, SchoolService schoolService)
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

            Course course1 = new Course();
            course1.setCourseCode("ANTH 101");
            course1.setCourseName("Intro to Cultural Anthropology");
            course1.setGrade("C");
            course1.setSchool(rvcc);
            course1.setSchoolYear("2007-2008");
            course1.setSeason(Seasons.FALL);
            course1.setYear(2007);
            courseService.save(course1);

            Course course2 = new Course();
            course2.setCourseCode("MATH 222");
            course2.setCourseName("Statistics I");
            course2.setGrade("B+");
            course2.setSchool(rvcc);
            course2.setSchoolYear("2007-2008");
            course2.setSeason(Seasons.FALL);
            course2.setYear(2007);
            courseService.save(course2);

            System.out.println("Demo data created");
        };
    }
}
