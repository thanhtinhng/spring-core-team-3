package org.example.ORM.hibernate;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "class") // ánh xạ với bảng "class"
public class ClassRoom {
    @Id //khóa chính
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    // Một lớp học có nhiều sinh viên
    @OneToMany(mappedBy = "classRoom", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Student> students;
    // mappedBy = "classRoom"    -   Trong Student có thuộc tính: private ClassRoom classRoom; (khóa ngoại)
    // cascade = CascadeType.ALL -   Tự động áp dụng các thao tác như persist, merge, remove, refresh, detach từ ClassRoom đến tất cả các Student thuộc lớp đó.
    //                               Ví dụ: khi gọi persist(ClassRoom) thì tất cả Student trong danh sách sẽ được persist.
    // orphanRemoval = true      -   Nếu một Student bị xóa khỏi danh sách `students` của ClassRoom thì bản ghi Student đó sẽ bị xóa khỏi database.

    public void setName(String name) {
        this.name = name;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "ClassRoom{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
