package ru.spbu.liubove.gui.config;

import org.springframework.context.annotation.*;
import ru.spbu.liubove.spring.jdbc.config.DbConfig;

@Configuration
@PropertySource("jdbc.properties")
@Import(DbConfig.class)
@ComponentScan(basePackages = "ru.spbu.liubove")
public class SpringConfig {
}
