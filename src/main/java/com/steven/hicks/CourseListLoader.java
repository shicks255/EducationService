package com.steven.hicks;

import com.steven.hicks.entities.Course;
import com.steven.hicks.entities.CourseId;
import com.steven.hicks.entities.School;
import com.steven.hicks.entities.Seasons;
import com.steven.hicks.repositories.CourseService;
import com.steven.hicks.repositories.SchoolService;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

//@Service
public class CourseListLoader
{
    private ResourceLoader m_resourceLoader;
    private CourseService m_courseService;
    private SchoolService m_schoolService;

    @Autowired
    public CourseListLoader(ResourceLoader resourceLoader, CourseService courseService, SchoolService schoolService)
    {
        this.m_resourceLoader = resourceLoader;
        this.m_courseService = courseService;
        this.m_schoolService = schoolService;
    }

//    @PostConstruct
    public void readCourseListFile() throws IOException
    {
        Resource resource = m_resourceLoader.getResource("classpath:files/courseList.csv");
        File file = resource.getFile();

        processCourses(file);

        System.out.println(file);
    }

    private void processCourses(File file) throws IOException
    {
        CSVParser csvParser = new CSVParser(Files.newBufferedReader(file.toPath()), CSVFormat.DEFAULT.withFirstRecordAsHeader());
        for (CSVRecord record : csvParser)
        {
            System.out.println(record);

            String courseCode = record.get(0);
            Integer season = Integer.parseInt(record.get(1));
            Integer year = Integer.parseInt(record.get(2));
            String courseName = record.get(3);
            String grade = record.get(4);
            String schoolCode = record.get(5);

            CourseId courseId = new CourseId();
            courseId.setSeason(Seasons.getSeasonsFromValue(season));
            courseId.setCourseCode(courseCode);
            courseId.setYear(year);

            School school = m_schoolService.getByAcronim(schoolCode);

            Course newCourse = new Course();
            newCourse.setCourseId(courseId);
            newCourse.setGrade(grade);
            newCourse.setSchool(school);
            newCourse.setCourseName(courseName);

            m_courseService.save(newCourse);
        }

    }
}
