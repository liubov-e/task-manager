package ru.spbu.liubove.console;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.spbu.liubove.console.controller.ConsoleController;

@SpringBootApplication
public class Application implements CommandLineRunner {
    @Autowired
    private ConsoleController controller;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        controller.interactWithUser();
    }
}
