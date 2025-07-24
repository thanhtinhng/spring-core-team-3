package org.example.ORM.spring_data_jpa;

import org.example.ORM.entity_manager.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/students")
public class StudentController {


    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getAll() {
        return studentService.getAllStudents();
    }

    @GetMapping("/email")
    public Optional<Student> getByEmail(@RequestParam("email") String email) {
        return studentService.getStudentByEmail(email);
    }

    @PostMapping
    public Student create(@RequestBody Student student) {
        return studentService.addStudent(student);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        studentService.deleteStudent(id);
    }
}
