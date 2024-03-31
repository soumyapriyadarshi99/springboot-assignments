package com.taskmanager.controller;

import com.taskmanager.dto.TaskRequestDto;
import com.taskmanager.dto.TaskResponseDto;
import com.taskmanager.service.TaskManagerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @PostMapping("/task")
    @ResponseStatus(HttpStatus.CREATED)
    public TaskResponseDto createTask(@RequestBody TaskRequestDto taskRequestDto){
        return taskManagerService.createTask(taskRequestDto);
    }

    @GetMapping("/tasks")
    @ResponseStatus(HttpStatus.OK)
    public List<TaskResponseDto> getAllTasks(){
        return taskManagerService.getAllTasks();
    }

    @GetMapping("task/{id}")
    @ResponseStatus(HttpStatus.OK)
    public TaskResponseDto getTaskById(@PathVariable Long id){
        return taskManagerService.getTaskById(id);
    }

    @DeleteMapping("task/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity deleteTaskById(@PathVariable Long id){
        taskManagerService.deleteTaskById(id);
        return ResponseEntity.ok("Task With ID :"+id+" Deleted");
    }

    @PutMapping("/task/{id}")
    @ResponseStatus(HttpStatus.OK)
    public TaskResponseDto editTask(@PathVariable Long id , @RequestBody TaskRequestDto taskRequest){
        return taskManagerService.editTask(id,taskRequest);
    }


}
