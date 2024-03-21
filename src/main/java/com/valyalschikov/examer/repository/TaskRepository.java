package com.valyalschikov.examer.repository;

import com.valyalschikov.examer.Models.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TaskRepository extends JpaRepository<Task, Long> {

    List<Task> findAllByExamId(Long examId);
    Optional<Task> findById(Long taskId);
}
