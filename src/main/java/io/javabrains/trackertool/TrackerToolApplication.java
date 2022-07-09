package io.javabrains.trackertool;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class TrackerToolApplication {

    public static void main(String[] args) {
        SpringApplication.run(TrackerToolApplication.class, args);
    }

}
