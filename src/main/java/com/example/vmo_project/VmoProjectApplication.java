package com.example.vmo_project;

import com.github.javafaker.Faker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class VmoProjectApplication extends SpringBootServletInitializer {
//    @Override
//    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
//        return application.sources(VmoProjectApplication.class);
//    }

  public static void main(String[] args) {
    SpringApplication.run(VmoProjectApplication.class, args);
  }

  @Bean
  public Faker faker() {
    return new Faker();
  }
}
