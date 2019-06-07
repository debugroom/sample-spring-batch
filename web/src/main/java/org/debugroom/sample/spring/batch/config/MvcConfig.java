package org.debugroom.sample.spring.batch.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@ComponentScan("org.debugroom.sample.spring.batch.app.web")
@Configuration
public class MvcConfig implements WebMvcConfigurer {
}
