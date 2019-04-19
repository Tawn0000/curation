package io.github.tawn0000.curation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages={"io.github.tawn0000.curation"})
public class CurationApplication {

    public static void main(String[] args) {
        SpringApplication.run(CurationApplication.class, args);
    }

}
