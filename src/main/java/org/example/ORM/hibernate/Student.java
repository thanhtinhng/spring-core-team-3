package org.example.ORM.hibernate;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


@Entity //JPA Entity Mapping
@Table (name = "student") // ánh xạ với bảng "student"
public class Student {
    @Id //khóa chính
    @GeneratedValue(strategy = GenerationType.IDENTITY) // tự tăng ID
    private Long id;

    @NotBlank(message = "Tên không được để trống")  // Không null và không toàn khoảng trắng
    @Size(min = 2, max = 50, message = "Tên phải từ 2 đến 50 ký tự")
    private String name;

    @NotBlank
    private String email;

    @NotNull
    @Max(value = 100, message = "Tuổi tối đa là 100")
    private int age;

    @ManyToOne // nhiều sinh viên thuộc 1 lớp học
    @JoinColumn(name = "class_id")  // khóa ngoại trỏ đến bảng class
    private ClassRoom classRoom;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setClassRoom(ClassRoom classRoom) {
        this.classRoom = classRoom;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", classRoom=" + (classRoom != null ? classRoom.getName() : "null") +
                '}';
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

//docs validator: https://docs.jboss.org/hibernate/validator/9.0/reference/en-US/html_single/#validator-gettingstarted
