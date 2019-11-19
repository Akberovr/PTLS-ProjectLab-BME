package com.projectlab.bme.ptl;

import com.projectlab.bme.ptl.repository.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = UserRepository.class)
public class PtlApplication {

    public static void main(String[] args) {
        SpringApplication.run(PtlApplication.class, args);
    }

}
