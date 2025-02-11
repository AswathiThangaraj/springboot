package com.example.demo;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {
	private static final String defaultMessage = "Hello, %s!";
    private static final String welcomeMessage = "Welcome, %s!";
    private static final String farewellMessage = "Goodbye, %s!";
    private final AtomicLong messageCounter = new AtomicLong(); // Keeps track of message requests

    // Main message endpoint
    @GetMapping("/message")
    public Message message(@RequestParam(value = "name", defaultValue = "User") String name,
                           @RequestParam(value = "type", defaultValue = "default") String messageType) {

        String messageContent = String.format(defaultMessage, name);  // Default message is "Hello"
        
        // Change message based on the 'type' parameter
        if ("welcome".equalsIgnoreCase(messageType)) {
            messageContent = String.format(welcomeMessage, name);
        } else if ("farewell".equalsIgnoreCase(messageType)) {
            messageContent = String.format(farewellMessage, name);
        }
        
        return new Message(messageCounter.incrementAndGet(), messageContent);
    }

    // Endpoint to get the number of times a message has been requested
    @GetMapping("/messageCount")
    public String getMessageCount() {
        return "The message has been requested " + messageCounter.get() + " times.";
    }
}