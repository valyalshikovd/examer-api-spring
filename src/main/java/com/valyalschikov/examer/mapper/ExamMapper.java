package com.valyalschikov.examer.mapper;

import com.valyalschikov.examer.Models.Exam;
import com.valyalschikov.examer.dto.ExamDto;

public class ExamMapper {
    public static ExamDto mapToDto(Exam exam){
        return new ExamDto(
                exam.getId(),
                exam.getName(),
                exam.getToken(),
                exam.getDate());
    }
}
