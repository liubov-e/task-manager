package ru.spbu.liubove.gui;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import ru.spbu.liubove.domain.service.QuestionService;
import ru.spbu.liubove.gui.controller.MainController;

import javax.swing.*;

@SpringBootApplication
public class Application {
    public static void main( String[] args ) {
        ConfigurableApplicationContext ctx = new SpringApplicationBuilder(Application.class)
            .headless(false).run(args);
        QuestionService questionService = ctx.getBean(QuestionService.class);
        SwingUtilities.invokeLater(new MainController(questionService));
    }
}
