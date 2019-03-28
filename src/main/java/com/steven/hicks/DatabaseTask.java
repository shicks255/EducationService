package com.steven.hicks;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class DatabaseTask
{
    @Bean
    public CommandLineRunner createDatabase()
    {
        return args ->
        {
            System.out.println("Setting up database...");
            System.out.println("All done");
        };
    }
}
