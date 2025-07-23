package org.example.ORM;

import jakarta.persistence.*;
import java.util.List;

public class StudentDAO {
    private EntityManager entityManager;    // khởi tạo EntityManager – đối tượng trung tâm để thao tác với database trong JPA

    public StudentDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

//      persist() – thêm mới
//      find() – truy vấn theo ID
//      merge() – cập nhật
//      remove() – xoá
//      docs: https://docs.oracle.com/javaee/7/api/javax/persistence/EntityManager.html

    public void createStudent(Student student) {
        EntityTransaction tx = entityManager.getTransaction();
        try {
            tx.begin();
            entityManager.persist(student);
            tx.commit();
            System.out.println("\n**Tạo thành công student có tên: " + student.getName() + "\n");
        } catch (RuntimeException e) {
            if (tx.isActive()) tx.rollback();
            throw e;
        }
    }

    public Student findById(Long id) {
        return entityManager.find(Student.class, id);
    }

    public List<Student> findAll() {
        return entityManager.createQuery("SELECT s FROM Student s", Student.class).getResultList();
    }

    public void updateStudent(Student student) {
        EntityTransaction tx = entityManager.getTransaction();
        try {
            tx.begin();
            entityManager.merge(student);
            tx.commit();
        } catch (RuntimeException e) {
            if (tx.isActive()) tx.rollback();
            throw e;
        }
    }

    public void deleteStudent(Long id) {
        EntityTransaction tx = entityManager.getTransaction();
        try {
            tx.begin();
            Student s = entityManager.find(Student.class, id);
            if (s != null) entityManager.remove(s);
            tx.commit();
            System.out.println("\n**Xóa thành công student có id=" + id + "\n");
        } catch (RuntimeException e) {
            if (tx.isActive()) tx.rollback();
            throw e;
        }
    }

}