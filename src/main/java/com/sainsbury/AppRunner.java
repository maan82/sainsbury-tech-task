package com.sainsbury;

import com.sainsbury.controller.ScrapingController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;

public class AppRunner {

    public static void main(String[] args) throws IOException {
        ApplicationContext context = new AnnotationConfigApplicationContext("com.sainsbury");
        ScrapingController controller = context.getBean(ScrapingController.class);
        System.out.println(controller.scrape(context.getEnvironment().getProperty("scrapper.url")));
    }
}
