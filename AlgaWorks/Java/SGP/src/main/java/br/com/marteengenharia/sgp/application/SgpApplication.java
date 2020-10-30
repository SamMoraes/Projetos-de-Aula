package br.com.marteengenharia.sgp.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan(basePackages= {"br.com.marteengenharia.sgp.entity"})
@EnableJpaRepositories(basePackages= {"br.com.marteengenharia.sgp.repository"})
@ComponentScan(basePackages= {"br.com.marteengenharia.sgp.controller"})
@SpringBootApplication
public class SgpApplication {

	public static void main(String[] args) {
		SpringApplication.run(SgpApplication.class, args);
	}

}
