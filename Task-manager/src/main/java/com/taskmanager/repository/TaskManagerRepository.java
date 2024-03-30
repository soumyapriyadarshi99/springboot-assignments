package com.taskmanager.repository;

import com.taskmanager.model.TaskManagerModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskManagerRepository extends JpaRepository<TaskManagerModel,Long> {
}
