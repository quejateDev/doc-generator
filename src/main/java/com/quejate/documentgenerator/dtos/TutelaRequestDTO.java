package com.quejate.documentgenerator.dtos;

import lombok.Data;

@Data
public class TutelaRequestDTO {
    private String fullName;
    private String documentNumber;
    private String city;
    private String department;
    private String rightViolated;
    private String entity;
    private String pqrType;
    private String pqrDate;
    private int daysExceeded;
    private String pqrDescription;
}
