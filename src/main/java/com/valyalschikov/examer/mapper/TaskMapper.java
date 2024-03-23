package com.valyalschikov.examer.mapper;

import com.valyalschikov.examer.Models.Task;
import com.valyalschikov.examer.dto.TaskDto;

import java.util.ArrayList;
import java.util.List;

public class TaskMapper {


    public static TaskDto mapToDto(Task task){



        return new TaskDto(task.getId(),
                task.getExamId(),
                task.getNum(),
                task.getQuestion(),
                task.getDescription(),
                task.getAnswer(),
                task.getDate()
        );
    }
}
