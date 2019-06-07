package org.debugroom.sample.spring.batch.app.batch.launcher;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Import;

import org.debugroom.sample.spring.batch.config.BatchAppConfig;

@Import(BatchAppConfig.class)
@SpringBootApplication
public class BatchApplication {

    public static void main(String[] args) {
        String inputParam = "param=1";
        new SpringApplicationBuilder(BatchApplication.class)
                .web(WebApplicationType.NONE)
                .run(new String[]{inputParam});
    }

}
