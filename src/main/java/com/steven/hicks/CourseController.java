package com.steven.hicks;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("/course")
public class CourseController
{
    @RequestMapping(method = RequestMethod.GET)
    public String getCourse(@RequestParam(name = "id") long id)
    {

        return "";
    }
}
