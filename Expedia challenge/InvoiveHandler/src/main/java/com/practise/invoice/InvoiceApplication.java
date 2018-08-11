package com.practise.invoice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.core.env.StandardEnvironment;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication(scanBasePackages = {"com.practise.invoice"})
@EnableAutoConfiguration
public class InvoiceApplication {

	public static void main(String[] args) {


		StandardEnvironment environment = new StandardEnvironment();
		new SpringApplicationBuilder()
				.sources(InvoiceApplication.class)
				.run(args);
	}
}
