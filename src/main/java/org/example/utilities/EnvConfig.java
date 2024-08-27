package org.example.utilities;

import io.github.cdimascio.dotenv.Dotenv;

public class EnvConfig {
    private static Dotenv dotenv = Dotenv.configure()
            .filename("data.env")
            .directory("C:\\Users\\piotr.kozieja\\Desktop\\SpringBoot\\Salesforce-Cucumber-Demountitled")
            .load();

    public static String get(String key) {
        return dotenv.get(key);
    }
}
