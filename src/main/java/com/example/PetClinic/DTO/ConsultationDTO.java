package com.example.PetClinic.DTO;

import lombok.Data;

import java.util.Date;

@Data
public class ConsultationDTO {
    private Long petId;
    private Date consultationDate;
    private double fee;
    private String description;
}
