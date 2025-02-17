package com.example.messagingredis;

//AtomicInteger => thread-safe operations on an integer value
import java.util.concurrent.atomic.AtomicInteger;

//Logger is used for logging messages
import org.slf4j.Logger;
//LoggerFactory creates a logger instance for the class
import org.slf4j.LoggerFactory;

public class Receiver {
    private static final Logger LOGGER = LoggerFactory.getLogger(Receiver.class);

    private AtomicInteger counter = new AtomicInteger();

    public void receiveMessage(String message) {
        LOGGER.info("Received <" + message + ">");
        counter.incrementAndGet();
    }

    public int getCount() {
        return counter.get();
    }
}