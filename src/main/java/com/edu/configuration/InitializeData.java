/*
 * (C) Copyright 2024 Fresher Spring. All rights reserved.
 * @Author HoangMH1
 * @Date Sep 08, 2024
 * @Version 1.0
 */

package com.edu.configuration;

import com.edu.data.TodoItem;
import com.edu.data.TodoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InitializeData {

    @Bean
    public CommandLineRunner initializeDataForMe(TodoRepository todoRepository) {
        return _ -> {
            todoRepository.save(new TodoItem(1L, false, "Learn Spring Boot"));
            todoRepository.save(new TodoItem(2L, false, "Learn Spring MVC"));
            todoRepository.save(new TodoItem(3L, false, "Learn Spring Data JPA"));
            todoRepository.save(new TodoItem(4L, false, "Learn Spring Security"));
            todoRepository.save(new TodoItem(5L, false, "Learn Spring Cloud"));
        };
    }
}