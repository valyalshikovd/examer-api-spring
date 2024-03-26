package com.valyalschikov.examer.controllers;


import com.valyalschikov.examer.dto.TaskDto;
import com.valyalschikov.examer.services.TaskService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/task")
@CrossOrigin(origins = "*")
public class TaskController {

    TaskService taskService;

    @PostMapping()
    public ResponseEntity<TaskDto> create(@RequestBody TaskDto taskDto) throws  IOException {
        try {
            taskDto = taskService.createTask(taskDto);
        }catch (Exception e){
            return ResponseEntity.status(400).build();
        }

        return ResponseEntity.ok(taskDto);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<TaskDto> update(
            @RequestBody TaskDto taskDto,
            @PathVariable("id") Long id
    ){
        try {
            return ResponseEntity.ok(taskService.update(taskDto, id));
        }catch (Exception e){
            return ResponseEntity.status(404).build();
        }
    }

    @GetMapping("/{token}")
    public ResponseEntity<List<TaskDto>> getAllByToken(
            @PathVariable("token") String token
    ){
        try{
            List<TaskDto> res = taskService.getByExamToken(token);
            return ResponseEntity.ok(res);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return ResponseEntity.status(400).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(Long id){
        try {
            taskService.delete(id);
            return ResponseEntity.status(200).build();
        }catch (Exception e){
            return ResponseEntity.status(400).build();
        }
    }

}
