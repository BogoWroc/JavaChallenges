package org.example;

import java.util.List;

public class Lambda {

    public record Email(String recipient, String title, String content) {
    }

    public record Customer(long id, String name, String emailAddress) {
    }

    @FunctionalInterface
    public interface EmailSender {
        void send(Email email);
    }

    public void formatAndSendMail(String title, String content, List<Customer> customers, EmailSender emailSender) {
        // Add your solution here
        customers.stream()
                .map(it -> new Email(it.emailAddress, title, String.format(content, it.name)))
                .forEach(emailSender::send);
    }

}
