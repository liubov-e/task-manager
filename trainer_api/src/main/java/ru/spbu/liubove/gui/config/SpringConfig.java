package ru.spbu.liubove.gui.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:jdbc.properties")
@ComponentScan(basePackages = "ru.spbu.liubove")
public class SpringConfig {
}
