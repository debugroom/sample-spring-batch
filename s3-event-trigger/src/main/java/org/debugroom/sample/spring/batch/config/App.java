package org.debugroom.sample.spring.batch.config;

import org.debugroom.sample.spring.batch.app.S3FileUploadHelper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class App {

    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(App.class, args);
        S3FileUploadHelper s3FileUploadHelper = applicationContext.getBean(
                S3FileUploadHelper.class);
        s3FileUploadHelper.saveFile("/test.txt");
    }

    @Bean
    public S3FileUploadHelper s3FileUploadHelper(){
        return new S3FileUploadHelper();
    }

}
