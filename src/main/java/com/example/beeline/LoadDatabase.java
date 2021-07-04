package com.example.beeline;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class LoadDatabase {
    @Bean
    CommandLineRunner initDatabase(AccountRepository accountRepository) {
        return args -> {
            accountRepository.save(new Account(11111111, 0));
            accountRepository.save(new Account(11111112, 1000));
            accountRepository.save(new Account(11111113, 2000));
            accountRepository.save(new Account(11111114, 3000));
            accountRepository.save(new Account(11111115, 4000));
            accountRepository.save(new Account(11111116, 5000));
        };
    }
}
