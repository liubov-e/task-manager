package ru.spbu.liubove.gui;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.spbu.liubove.gui.config.SpringConfig;
import ru.spbu.liubove.gui.controller.MainController;

public class Application
{
    public static void main( String[] args )
    {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        MainController controller = context.getBean(MainController.class);
        controller.interactWithUser();
    }
}
