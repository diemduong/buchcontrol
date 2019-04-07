package com.buchdemo.buchcontrol;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;

@SpringBootApplication
@ComponentScan (basePackages =  ("com.buchdemo.buchcontrol.*"))
public class BuchcontrolApplication {

	public static void main(String[] args) {
		SpringApplication.run(BuchcontrolApplication.class, args);
	}
}
