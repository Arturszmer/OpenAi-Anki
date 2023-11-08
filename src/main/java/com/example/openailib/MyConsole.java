package com.example.openailib;

import com.example.openailib.model.ChatCompletionResponse;
import com.example.openailib.model.ChatMessage;
import com.example.openailib.service.ChatService;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.Scanner;

import static com.example.openailib.model.OpenAiRoles.*;

@Component
public class MyConsole {
    private final ChatService chatService;
    private final Scanner scanner;

    public MyConsole(ApplicationContext context) {
        this.chatService = context.getBean(ChatService.class);
        this.scanner = new Scanner(System.in);
    }

    public void readUserInput() {
        System.out.println("start conversation, if you want to end it, press 'exit'): ");
        while (true) {
            String command = scanner.nextLine();

            if ("exit".equalsIgnoreCase(command)) {
                break;
            } else {
                ChatCompletionResponse conversation = chatService.conversation(new ChatMessage(command, USER.getRole()));
                System.out.println(conversation.getChoices().get(0).getMessage().getContent());
            }
        }

        System.out.println("Exiting the application.");
        scanner.close();
    }
}
