package com.mkyong;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;

@SpringBootApplication
public class StartBookApplication {

    // start everything
    public static void main(String[] args) {
        SpringApplication.run(StartBookApplication.class, args);
    }

    // run this only on profile 'demo', avoid run this in test
    @Profile(value = { "demo" })
    @Bean
    CommandLineRunner initDatabase(JpaRepository repository) {
        return args -> {
            repository.save(new Book("My history", "VISHNU", new BigDecimal("15.41")));
            repository.save(new Book("My first book", "SIDDHU", new BigDecimal("9.69")));
            repository.save(new Book("Book on Spring", null, new BigDecimal("47.99")));
        };
    }
}