package com.example.openailib;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@EnableFeignClients
public class OpenAiLibApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(OpenAiLibApplication.class, args);
        MyConsole bean = context.getBean(MyConsole.class);
        bean.readUserInput();
    }

}
