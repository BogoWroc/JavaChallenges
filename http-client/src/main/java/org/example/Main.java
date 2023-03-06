package org.example;

import java.io.IOException;
import java.net.URISyntaxException;

public class Main {
    public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {
        var response = SimpleHttpClient.responseFromServer("http://localhost:9080/");

        System.out.println(response.statusCode());
        System.out.println(response.body());


    }
}