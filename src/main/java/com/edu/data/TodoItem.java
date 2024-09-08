/*
 * (C) Copyright 2024 Fresher Spring. All rights reserved.
 * @Author HoangMH1
 * @Date Sep 08, 2024
 * @Version 1.0
 */

package com.edu.data;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class TodoItem implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private boolean completed;
    private String description;

    @Override
    public String toString() {
        return id + " " + (completed ? "[COMPLETED]" : "[ ] ") + description;
    }
}
