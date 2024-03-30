package com.taskmanager.controller;

import com.taskmanager.dto.TaskRequestDto;
import com.taskmanager.dto.TaskResponseDto;
import com.taskmanager.model.TaskManagerModel;
import com.taskmanager.service.TaskManagerService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/taskmanager")
@AllArgsConstructor
public class TaskManagerController {

    private final TaskManagerService taskManagerService;

    @GetMapping("/getDemo")
    @ResponseStatus(HttpStatus.OK)
    public String createDemoApiForCheck(){
        return "Working fine";
    }

    @PostMapping("/createTask")
    @ResponseStatus(HttpStatus.CREATED)
    public TaskManagerModel createTask(@RequestBody TaskRequestDto taskRequestDto){
        return taskManagerService.createTask(taskRequestDto);
    }

}
