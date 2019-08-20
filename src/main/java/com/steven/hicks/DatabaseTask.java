package com.steven.hicks;

import com.steven.hicks.entities.Course;
import com.steven.hicks.entities.CourseId;
import com.steven.hicks.entities.School;
import com.steven.hicks.entities.Seasons;
import com.steven.hicks.repositories.CourseService;
import com.steven.hicks.repositories.CourseworkService;
import com.steven.hicks.repositories.SchoolService;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

@Service
public class DatabaseTask
{
    @Bean
    public CommandLineRunner createDatabase(CourseService courseService,
                                            SchoolService schoolService,
                                            CourseworkService courseworkService,
                                            ResourceLoader resourceLoader) throws IOException
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
            System.out.println("School Objects created");

            Resource resource = resourceLoader.getResource("classpath:files/courseList.csv");
            File file = resource.getFile();

            CSVParser csvParser = new CSVParser(Files.newBufferedReader(file.toPath()), CSVFormat.DEFAULT.withFirstRecordAsHeader());
            for (CSVRecord record : csvParser)
            {
                String courseCode = record.get(0);
                Integer season = Integer.parseInt(record.get(1).trim());
                Integer year = Integer.parseInt(record.get(2).trim());
                String courseName = record.get(3);
                String grade = record.get(4);
                String schoolCode = record.get(5);

                CourseId courseId = new CourseId();
                courseId.setSeason(Seasons.getSeasonsFromValue(season));
                courseId.setCourseCode(courseCode);
                courseId.setYear(year);

                School school = schoolService.getByAcronim(schoolCode);

                Course newCourse = new Course();
                newCourse.setCourseId(courseId);
                newCourse.setGrade(grade);
                newCourse.setSchool(school);
                newCourse.setCourseName(courseName);

                courseService.save(newCourse);
            }
        };
    }
}
