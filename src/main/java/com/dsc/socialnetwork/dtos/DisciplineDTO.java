package com.dsc.socialnetwork.dtos;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

public class DisciplineDTO {
    @NotBlank
    private String name;

    @Min(0)
    private double note;
    
    public DisciplineDTO(String name, double note) {
        this.name = name;
        this.note = note;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getNote() {
        return note;
    }

    public void setNote(double note) {
        this.note = note;
    }

}