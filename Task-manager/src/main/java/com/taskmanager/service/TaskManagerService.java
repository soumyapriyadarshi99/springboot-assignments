package com.taskmanager.service;

import com.taskmanager.dto.TaskRequestDto;
import com.taskmanager.dto.TaskResponseDto;
import com.taskmanager.exceptions.NotFoundException;
import com.taskmanager.mapper.TaskMapper;
import com.taskmanager.model.TaskManagerModel;
import com.taskmanager.repository.TaskManagerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class TaskManagerService {
    private final TaskManagerRepository taskManagerRepository;

    public TaskResponseDto createTask(TaskRequestDto taskRequestDto){
        TaskManagerModel task=TaskManagerModel.builder()
                .title(taskRequestDto.getTitle())
                .description(taskRequestDto.getDescription())
                .completed(taskRequestDto.getCompleted())
                .build();
        TaskManagerModel newTask= taskManagerRepository.save(task);
        TaskResponseDto createdTask=TaskMapper.mapToTaskResponse(newTask);
        return createdTask;
    }

    public List<TaskResponseDto> getAllTasks(){
        List<TaskManagerModel> taskLists =taskManagerRepository.findAll();
        List<TaskResponseDto> taskListsResponse= taskLists.stream().map(item->TaskMapper.mapToTaskResponse(item)).collect(Collectors.toList());
        return taskListsResponse;
    }

    public TaskResponseDto getTaskById(Long id){
        Optional<TaskManagerModel> taskOptional = taskManagerRepository.findById(id);
        if(taskOptional.isPresent()){
            TaskManagerModel task=taskOptional.get();
            return TaskMapper.mapToTaskResponse((task));
        }else{
            throw new NotFoundException("Task not found with id: "+id);
        }
    }

        public void deleteTaskById(Long id) {
            Optional<TaskManagerModel> optionalTask=taskManagerRepository.findById(id);
            if(optionalTask.isPresent()){
                taskManagerRepository.deleteById(id);
            }else{
                throw new NotFoundException("Task not found with id: "+id);
            }
        }
}
