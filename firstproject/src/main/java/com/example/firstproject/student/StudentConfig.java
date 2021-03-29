package com.example.firstproject.student;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StudentConfig {
    private static final Month NOVEMBER = Month.NOVEMBER;

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository) {
        return args -> {
            Student charlie = new Student(
                1L,
                "Charlie",
                "CharlieWilson@gmail.com",
                LocalDate.of(2000, NOVEMBER, 29)
            );

            Student nemo = new Student(
                "nemo",
                "nemo@gmail.com",
                LocalDate.of(2000, NOVEMBER, 25)
            );

            repository.saveAll(
                List.of(charlie, nemo)
            );
        };
    }
}
