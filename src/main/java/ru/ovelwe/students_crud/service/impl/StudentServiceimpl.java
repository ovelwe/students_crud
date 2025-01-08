package ru.ovelwe.students_crud.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.ovelwe.students_crud.model.Student;
import ru.ovelwe.students_crud.repository.StudentRepository;
import ru.ovelwe.students_crud.service.StudentService;

import java.util.List;


@Service
@AllArgsConstructor
@Primary
public class StudentServiceimpl implements StudentService {
    private final StudentRepository studentRepository;

    @Override
    public List<Student> findAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student findByEmail(String email) {
        return studentRepository.findByEmail(email);
    }

    @Override
    public Student updateStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    @Transactional
    public void deleteStudent(String email) {
        studentRepository.deleteByEmail(email);
    }
}
