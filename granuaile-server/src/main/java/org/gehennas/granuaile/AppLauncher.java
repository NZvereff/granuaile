package org.gehennas.granuaile;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@SpringBootApplication
public class AppLauncher {

    public static void main(String... args) {
        SpringApplication.run(AppLauncher.class, args);
    }
}
