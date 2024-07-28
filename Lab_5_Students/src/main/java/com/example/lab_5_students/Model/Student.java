package com.example.lab_5_students.Model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Student {
    private String name;
    private int age;
    private String degree;
    private boolean status;

    public boolean getStatus(){
        return this.status;
    }
}
