package com.valyalschikov.examer.controllers;


import com.valyalschikov.examer.dto.ExamDto;
import com.valyalschikov.examer.dto.RequestExamDto;
import com.valyalschikov.examer.services.ExamService;
import com.valyalschikov.examer.services.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("api/v1/exam")
public class ExamController {

    ExamService examService;
    TaskService taskService;

    @PostMapping
    public ResponseEntity<String> createExam(@RequestBody RequestExamDto examDto){
        if(examDto == null || examDto.getName() == null )
            return ResponseEntity.status(400).build();
        try {
            ExamDto createdExam = examService.createExam(examDto.getName());
            return ResponseEntity.ok(createdExam.getToken());
        }catch (Exception e){
            return ResponseEntity.status(400).build();
        }
    }

    @DeleteMapping("/{token}")
    public ResponseEntity<ExamDto> deleteExam(@PathVariable String token){
        try{
            ExamDto examDto = examService.delete(token);
            taskService.deleteAllByExamId(token);
            return  ResponseEntity.ok(examDto);
        }catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }
}
