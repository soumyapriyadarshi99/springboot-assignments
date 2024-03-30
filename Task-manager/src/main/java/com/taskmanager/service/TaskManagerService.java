package com.taskmanager.service;

import com.taskmanager.dto.TaskRequestDto;
import com.taskmanager.dto.TaskResponseDto;
import com.taskmanager.model.TaskManagerModel;
import com.taskmanager.repository.TaskManagerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TaskManagerService {
    private final TaskManagerRepository taskManagerRepository;

    public TaskManagerModel createTask(TaskRequestDto taskRequestDto){
        TaskManagerModel task=TaskManagerModel.builder()
                .title(taskRequestDto.getTitle())
                .description(taskRequestDto.getDescription())
                .completed(taskRequestDto.getCompleted())
                .build();
        TaskManagerModel newTask= taskManagerRepository.save(task);
        return newTask;
    }


}
