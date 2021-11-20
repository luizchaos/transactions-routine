package org.lhtc.application;


import org.lhtc.entity.OperationsTypes;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.lhtc.repository.OperationTypesRepository;

@SpringBootApplication
@EntityScan(basePackages = { "org.lhtc.entity" })
@EnableJpaRepositories(basePackages = { "org.lhtc.repository" })
@ComponentScan(basePackages = {"org.lhtc.controller"})
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
