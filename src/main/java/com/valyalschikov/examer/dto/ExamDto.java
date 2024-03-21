package com.valyalschikov.examer.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class ExamDto {
    private Long id;
    private String name;
    private String token;
    private LocalDate date;
}
