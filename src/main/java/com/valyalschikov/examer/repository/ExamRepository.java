package com.valyalschikov.examer.repository;

import com.valyalschikov.examer.Models.Exam;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExamRepository extends JpaRepository<Exam, Long> {
    Exam findByToken(String token);

}
