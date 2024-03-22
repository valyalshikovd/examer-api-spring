package com.valyalschikov.examer.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
public class RequestExamDto {
    private String name;
    private String something;
}
