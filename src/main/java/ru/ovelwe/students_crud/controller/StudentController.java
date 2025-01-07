package ru.ovelwe.students_crud.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.ovelwe.students_crud.model.Student;
import ru.ovelwe.students_crud.service.StudentService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
@AllArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping
    public List<Student> findAllStudents() {
        return studentService.findAllStudents();
    }

    @PostMapping("create_student")
    public Student createStudent(@RequestBody Student student) {
        return studentService.createStudent(student);
    }

    @GetMapping("/{email}")
    public Student findStudentByEmail(@PathVariable String email) {
        return studentService.findByEmail(email);
    }

    @PostMapping("update_student")
    public Student updateStudent(Student student) {
        return studentService.updateStudent(student);
    }

    @DeleteMapping("delete_student/{email}")
    public void deleteStudent(@PathVariable String email) {
        studentService.deleteStudent(email);
    }
}
