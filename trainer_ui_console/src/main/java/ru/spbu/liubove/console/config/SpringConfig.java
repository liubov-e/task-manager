package ru.spbu.liubove.console.config;

import org.springframework.context.annotation.*;

@Configuration
@PropertySource("jdbc.properties")
@ComponentScan(basePackages = "ru.spbu.liubove")
public class SpringConfig {
}
