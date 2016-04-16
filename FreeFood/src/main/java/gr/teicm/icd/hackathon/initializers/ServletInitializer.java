package gr.teicm.icd.hackathon.initializers;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;

import gr.teicm.icd.hackathon.FreeFoodApplication;

public class ServletInitializer extends SpringBootServletInitializer {
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(FreeFoodApplication.class);
	}
}
