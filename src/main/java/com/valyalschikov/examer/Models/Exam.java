package com.valyalschikov.examer.Models;


import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;


import java.time.LocalDate;
import java.util.Collection;

@Entity
@Table(name="exams")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Exam  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "examId")
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "token", nullable = false, unique = true)
    private String token;

    @CreatedDate
    @Column(name = "date", nullable = false)
    private LocalDate date;
}
