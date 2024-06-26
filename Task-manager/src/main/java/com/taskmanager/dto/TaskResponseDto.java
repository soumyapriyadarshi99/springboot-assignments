package com.taskmanager.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class TaskResponseDto {
    private String title;
    private String description;
    private Boolean completed;
    private Long id;
}
