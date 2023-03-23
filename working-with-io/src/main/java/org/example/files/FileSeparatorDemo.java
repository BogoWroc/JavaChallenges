package org.example.files;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileSeparatorDemo {

    static String filePath = "working-with-io/src/main/resources/modules.txt";
    static String filePath2 = "working-with-io\\src\\main\\resources\\modules.txt";

    public static void main(String[] args) throws IOException {

        System.out.println(Files.exists(Path.of(filePath)));
        System.out.println(Files.exists(Path.of(filePath2)));

        Path path = Path.of("working-with-io", "src", "main", "resources", "modules.txt");
    }
}
