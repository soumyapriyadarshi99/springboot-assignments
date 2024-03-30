package com.taskmanager.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tasks")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TaskManagerModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private Boolean completed;
}
