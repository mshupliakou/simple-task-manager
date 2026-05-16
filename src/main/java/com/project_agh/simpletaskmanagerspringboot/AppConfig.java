package com.project_agh.simpletaskmanagerspringboot;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan
@PropertySource("classpath:task-manager.properties")
public class AppConfig {

}
