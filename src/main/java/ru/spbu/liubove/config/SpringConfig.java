package ru.spbu.liubove.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import ru.spbu.liubove.Application;

@Configuration
@ComponentScan(basePackageClasses = Application.class)
public class SpringConfig {
}
