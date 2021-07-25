package com.mhasancmt.testApp.student;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StudentConfig {
	@Bean
	CommandLineRunner commandLineRunner(StudentRepository repository) {
		return args ->{
			Student hasan=new Student(
					"hasan",
					"mail.com",
					LocalDate.of(2001, Month.JANUARY, 19)
					);
			Student mahmud=new Student(
					"mahmud",
					"mahmud@gmail.com",
					LocalDate.of(2002, Month.FEBRUARY, 19)
					);
			repository.saveAll(
					List.of(hasan,mahmud)
					);
		};
	}
}
