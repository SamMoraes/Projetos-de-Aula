package com.algaworks.osworks;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan(basePackages= {"com.algaworks.osworks.domain.model"})
@EnableJpaRepositories(basePackages= {"com.algaworks.osworks.domain.repository"})
@ComponentScan(basePackages= {"com.algaworks.osworks.api.controller"})
@SpringBootApplication
public class OsworksApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(OsworksApiApplication.class, args);
	}

}
