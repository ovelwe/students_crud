package ru.ovelwe.students_crud.model;

import lombok.*;

import java.time.LocalDate;

@Data
@Builder
public class Student {
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    @NonNull
    private String email;
    private int age;
}
