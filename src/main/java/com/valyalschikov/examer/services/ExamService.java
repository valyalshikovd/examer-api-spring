package com.valyalschikov.examer.services;

import com.valyalschikov.examer.dto.ExamDto;

public interface ExamService {

    ExamDto createExam(String name);
    ExamDto delete(String token);
    String createLink(ExamDto examDto);
}
