package com.valyalschikov.examer.services.impl;

import com.valyalschikov.examer.Models.Exam;
import com.valyalschikov.examer.dto.ExamDto;
import com.valyalschikov.examer.exceptions.NotFoundException;
import com.valyalschikov.examer.mapper.ExamMapper;
import com.valyalschikov.examer.repository.ExamRepository;
import com.valyalschikov.examer.services.ExamService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.security.SecureRandom;
import java.time.LocalDate;
import java.util.Base64;


@Service
@AllArgsConstructor
public class ExamServiceImpl implements ExamService {

    private ExamRepository examRepository;

    @Override
    public ExamDto createExam(String name) {

        if( name == null)
            throw new IllegalArgumentException();

        Exam exam = Exam
                .builder()
                .name(name)
                .token(createToken())
                .date(LocalDate.now())
                .build();

        examRepository.save(exam);
        return ExamMapper.mapToDto(exam);
    }

    @Override
    public ExamDto delete(String token) {

        Exam exam = examRepository.findByToken(token);

        if(exam == null){
            throw new NotFoundException();
        }

        examRepository.delete(exam);
        return ExamMapper.mapToDto(exam);
    }

    @Override
    public String createLink(ExamDto examDto) {
        return null;
    }

    @Override
    public ExamDto getExamByToken(String token) {
        Exam exam = examRepository.findByToken(token);

        if(exam == null){
            throw new NotFoundException();
        }

        return ExamMapper.mapToDto(exam);
    }

    private String createToken() {
        SecureRandom random = new SecureRandom();
        byte[] token = new byte[24];
        random.nextBytes(token);
        String string = Base64.getEncoder().encodeToString(token);

        if(examRepository.findByToken(string) != null){
            return createToken();
        };

        return string;
    }
}
