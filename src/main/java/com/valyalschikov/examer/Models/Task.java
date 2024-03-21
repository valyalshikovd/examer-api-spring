package com.valyalschikov.examer.Models;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDate;

@Entity
@Table(name = "tasks")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "examId")
    private Long id;
    @Column(name = "name", nullable = false)
    private Long examId;
    @Column(name = "num", nullable = false)
    private int num;
    @Column(name = "question", nullable = false)
    private String question;
    @Column(name = "description", nullable = false)
    private String description;
    @Column(name = "answer")
    private String answer;
    @CreatedDate
    @Column(name = "date", nullable = false)
    private LocalDate date;
}
