package com.taskmanager.mapper;

import com.taskmanager.dto.TaskResponseDto;
import com.taskmanager.model.TaskManagerModel;
import lombok.AllArgsConstructor;

import java.util.Optional;

@AllArgsConstructor
public class TaskMapper {
    private final TaskResponseDto taskResponseDto;
    public static TaskResponseDto mapToTaskResponse(TaskManagerModel task){
        TaskResponseDto taskResponse=new TaskResponseDto();
        taskResponse.setId(task.getId());
        taskResponse.setTitle(task.getTitle());
        taskResponse.setCompleted(task.getCompleted());
        taskResponse.setDescription(task.getDescription());
        return taskResponse;
    }
}
