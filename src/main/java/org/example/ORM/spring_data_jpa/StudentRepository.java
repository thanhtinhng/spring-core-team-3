package org.example.ORM.spring_data_jpa;

import org.example.ORM.hibernate.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    // Tìm sinh viên theo email
    Optional<Student> findByEmail(String email);
}