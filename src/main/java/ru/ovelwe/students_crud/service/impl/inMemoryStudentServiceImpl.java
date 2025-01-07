package ru.ovelwe.students_crud.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.ovelwe.students_crud.model.Student;
import ru.ovelwe.students_crud.repository.inMemoryStudentDAO;
import ru.ovelwe.students_crud.service.StudentService;

import java.util.List;

@Service
@AllArgsConstructor
public class inMemoryStudentServiceImpl implements StudentService {
    private final inMemoryStudentDAO repository;

    @Override
    public List<Student> findAllStudents() {
        return repository.findAllStudents();
    }

    @Override
    public Student saveStudent(Student student) {
        return repository.saveStudent(student);
    }

    @Override
    public Student findByEmail(String email) {
        return repository.findByEmail(email);
    }

    @Override
    public Student updateStudent(Student student) {
        return repository.updateStudent(student);
    }

    @Override
    public void deleteStudent(String email) {
        repository.deleteStudent(email);
    }
}
