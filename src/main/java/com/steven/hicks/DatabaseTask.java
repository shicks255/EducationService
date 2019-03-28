package com.steven.hicks;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class DatabaseTask
{
    @Bean
    public CommandLineRunner createDatabase(CourseService courseService)
    {
        return args ->
        {
            System.out.println("Setting up dummy data");

            Course course1 = new Course();
            course1.setCourseCode("ANTH 101");
            course1.setCourseName("Intro to Cultural Anthropology");
            course1.setGrade("C");
            course1.setSchoolId("RVCC");
            course1.setSchoolYear("2007-2008");
            course1.setSeason(Seasons.FALL);
            course1.setYear(2007);
            courseService.save(course1);

            Course course2 = new Course();
            course2.setCourseCode("MATH 222");
            course2.setCourseName("Statistics I");
            course2.setGrade("B+");
            course2.setSchoolId("RVCC");
            course2.setSchoolYear("2007-2008");
            course2.setSeason(Seasons.FALL);
            course2.setYear(2007);
            courseService.save(course2);

            System.out.println("Demo data created");
        };
    }
}
