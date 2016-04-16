package gr.teicm.icd.hackathon.initializers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("gr.teicm.icd.hackathon")
@SpringBootApplication
public class FreeFoodApplication {

	public static void main(String[] args) {
		SpringApplication.run(FreeFoodApplication.class, args);
	}
}
