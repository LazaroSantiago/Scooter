package com.example.scooter;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import util.cargaData;


@SpringBootApplication
@ComponentScan({"util", "controller", "entity", "repository", "service", "com.example.scooter"})
@EnableJpaRepositories("repository")
@EntityScan("entity")
public class ScooterApplication {

    public static void main(String[] args) {
        SpringApplication.run(ScooterApplication.class, args);
    }

    @Autowired
    private cargaData cargaData;

    @PostConstruct
    public void init() {
//        cargaData.carga();
    }
}
