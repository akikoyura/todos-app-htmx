/*
 * (C) Copyright 2024 Fresher Spring. All rights reserved.
 * @Author HoangMH1
 * @Date Sep 08, 2024
 * @Version 1.0
 */

package com.edu.data;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<TodoItem, Long> {
}
