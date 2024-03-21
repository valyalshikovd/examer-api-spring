package com.valyalschikov.examer.controllers;


import com.valyalschikov.examer.dto.TaskDto;
import com.valyalschikov.examer.repository.TaskRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping
public class TaskController {

    TaskRepository taskRepository;

    @PostMapping
    public ResponseEntity<TaskDto> create(TaskDto taskDto){

    }



}
