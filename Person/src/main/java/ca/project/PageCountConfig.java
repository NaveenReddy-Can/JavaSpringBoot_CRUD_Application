package ca.project;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PageCountConfig {
	@Bean
	public PageCounter getPageCounter() {
		return new PageCounter();
	}

}
