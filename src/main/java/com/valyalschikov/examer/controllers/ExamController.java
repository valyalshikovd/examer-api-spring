package com.valyalschikov.examer.controllers;


import com.valyalschikov.examer.dto.ExamDto;
import com.valyalschikov.examer.dto.RequestExamDto;
import com.valyalschikov.examer.mapper.ExamMapper;
import com.valyalschikov.examer.services.ExamService;
import com.valyalschikov.examer.services.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("api/v1/exam")
@CrossOrigin(origins = "*")
public class ExamController {

    ExamService examService;
    TaskService taskService;

    @PostMapping
    public ResponseEntity<String> createExam(@RequestBody  String name){
        try {
            ExamDto createdExam = examService.createExam(name);
            return ResponseEntity.ok(createdExam.getToken());
        }catch (Exception e){
            return ResponseEntity.status(400).build();
        }
    }

    @GetMapping("/{token}")
    public ResponseEntity<ExamDto> getExam(@PathVariable(name = "token") String token){
        try {
            return ResponseEntity.ok(examService.getExamByToken(token));
        }catch (Exception e){
            return ResponseEntity.status(404).build();
        }
    }

    @DeleteMapping("/{token}")
    public ResponseEntity<ExamDto> deleteExam(@PathVariable(name = "token") String token){
        try{
            ExamDto examDto = examService.delete(token);
            taskService.deleteAllByExamId(token);
            return  ResponseEntity.ok(examDto);
        }catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }
}
