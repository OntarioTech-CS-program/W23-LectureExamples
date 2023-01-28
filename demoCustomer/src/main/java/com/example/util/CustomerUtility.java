package com.example.util;

import java.io.IOException;
import java.nio.file.Files;

public class CustomerUtility {
    public static String readFileContents(String filename) {
        try {
            java.nio.file.Path file = java.nio.file.Path.of(
                    String.valueOf(
                                    CustomerUtility.class.getResource(filename))
                            .substring(6));
            return Files.readString(file);
        } catch (IOException e) {
            // something went wrong
            return "Did you forget to create the file?\n" +
                    "Is the file in the right location?\n" +
                    e.toString();
        }
    }
}
