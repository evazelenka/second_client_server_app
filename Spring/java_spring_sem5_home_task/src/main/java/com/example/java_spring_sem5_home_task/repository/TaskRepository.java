package com.example.java_spring_sem5_home_task.repository;


import com.example.java_spring_sem5_home_task.domain.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TaskRepository extends JpaRepository<Task, Integer> {
    @Query()
    Task getTaskByStatus(String status);
}
