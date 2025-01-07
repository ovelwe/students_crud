package ru.ovelwe.students_crud.service;

import org.springframework.stereotype.Service;
import ru.ovelwe.students_crud.model.Student;

import java.util.List;

@Service
public interface StudentService {
   List<Student> findAllStudents();
   Student createStudent(Student student);
   Student findByEmail(String email);
   Student updateStudent(Student student);
   void deleteStudent(String email);
}
