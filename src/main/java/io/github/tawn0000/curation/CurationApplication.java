package io.github.tawn0000.curation;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
//@MapperScan({"io.github.tawn0000.curation.dao"})
public class CurationApplication {

    public static void main(String[] args) {
        SpringApplication.run(CurationApplication.class, args);
    }

}
