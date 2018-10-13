package ua.edu.ukma.e_oss;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = { "ua.edu.ukma.e_oss.controller","ua.edu.ukma.e_oss.config", "ua.edu.ukma.e_oss.service"})
public class EOssApplication {

	public static void main(String[] args) {
		SpringApplication.run(EOssApplication.class, args);
	}
}
