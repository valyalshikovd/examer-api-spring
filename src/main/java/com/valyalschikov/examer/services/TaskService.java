package com.valyalschikov.examer.services;

import com.valyalschikov.examer.dto.TaskDto;

import java.util.List;

public interface TaskService {

    TaskDto createTask(TaskDto taskDto);
    List<TaskDto> getByExamId(String token);
    TaskDto update(TaskDto taskDto, Long id);
    TaskDto delete(Long id);
    void deleteAllByExamId(String token);
}
