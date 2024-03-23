package com.valyalschikov.examer.services;

import com.valyalschikov.examer.dto.TaskDto;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface TaskService {


    TaskDto createTask(TaskDto taskDto);

    List<TaskDto> getByExamToken(String token);

    TaskDto update(TaskDto taskDto, Long id);

    TaskDto delete(Long id);

    void deleteAllByExamId(String token);

}
