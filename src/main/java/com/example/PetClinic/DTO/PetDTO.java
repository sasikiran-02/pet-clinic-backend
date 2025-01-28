package com.example.PetClinic.DTO;

import lombok.Data;

@Data
public class PetDTO {
    private String name;
    private String type;
    private Long ownerId;
}
