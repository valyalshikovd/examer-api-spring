package com.valyalschikov.examer.dto;

import com.valyalschikov.examer.Models.Image;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class TaskDto {
    private Long id;
    private Long examId;
    private int num;
    private String question;
    private String description;
    private String answer;
    private LocalDate date;
    private List<Image> imageList;
}

