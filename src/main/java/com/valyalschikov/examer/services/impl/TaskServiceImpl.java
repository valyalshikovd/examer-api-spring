package com.valyalschikov.examer.services.impl;

import com.valyalschikov.examer.Models.Task;
import com.valyalschikov.examer.dto.ExamDto;
import com.valyalschikov.examer.dto.TaskDto;
import com.valyalschikov.examer.exceptions.NotFoundException;
import com.valyalschikov.examer.mapper.TaskMapper;
import com.valyalschikov.examer.repository.TaskRepository;
import com.valyalschikov.examer.services.ExamService;
import com.valyalschikov.examer.services.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
public class TaskServiceImpl implements TaskService {

    private ExamService examService;
    private TaskRepository taskRepository;
    @Override
    public TaskDto createTask(TaskDto taskDto) {

        if(taskDto == null){
            throw new IllegalArgumentException();
        }

        Task createdTask = Task
                .builder()
                .num(taskDto.getNum())
                .date(LocalDate.now())
                .answer(taskDto.getAnswer())
                .description(taskDto.getDescription())
                .examId(taskDto.getExamId())
                .question(taskDto.getQuestion())
                .build();

        taskRepository.save(createdTask);

        return TaskMapper.mapToDto(createdTask);
    }

    @Override
    public List<TaskDto> getByExamToken(String token) {

        ExamDto examDto = examService.getExamByToken(token);
        List<Task> tasks = taskRepository.findAllByExamId(examDto.getId());
        return  tasks.stream().map( TaskMapper::mapToDto).toList();

    }

    @Override
    public TaskDto update(TaskDto taskDto, Long id) {

        Task task = taskRepository.findById(id).orElseThrow(
                () ->  new NotFoundException()
        );

        if(taskDto == null){
            throw new NotFoundException();
        }

        task.setNum(taskDto.getNum());
        task.setQuestion(taskDto.getQuestion());
        task.setDescription(taskDto.getDescription());
        task.setAnswer(taskDto.getAnswer());
        task.setDate(taskDto.getDate());
        taskRepository.save(task);

        return TaskMapper.mapToDto(task);
    }

    @Override
    public TaskDto delete(Long id) {

        Task task = taskRepository.findById(id).orElseThrow(
                () -> new NotFoundException()
        );

        taskRepository.delete(task);
        return TaskMapper.mapToDto(task);
    }

    @Override
    public void deleteAllByExamId(String token) {
        ExamDto examDto;
        try {
            examDto = examService.getExamByToken(token);
        }catch (Exception e){
            throw new NotFoundException();
        }
        List<Task> tasks = taskRepository.findAllByExamId(examDto.getId());
        taskRepository.deleteAll(tasks);
    }
}
