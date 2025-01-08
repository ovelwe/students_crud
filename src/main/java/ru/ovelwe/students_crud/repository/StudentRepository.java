package ru.ovelwe.students_crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.ovelwe.students_crud.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    void deleteByEmail(String email);
    Student findByEmail(String email);
}
