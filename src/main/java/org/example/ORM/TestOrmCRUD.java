package org.example.ORM;

import jakarta.persistence.*;

public class TestOrmCRUD {
    public static void main(String[] args) {
        // Tạo EntityManagerFactory từ file persistence.xml (tên unit là "orm-demo")
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("orm-demo");

        // Tạo EntityManager để thao tác với database
        EntityManager em = emf.createEntityManager();

        StudentDAO studentDAO = new StudentDAO(em);
        ClassRoomDAO classRoomDAO = new ClassRoomDAO(em);

        // Create ClassRoom
        ClassRoom c = new ClassRoom();
        c.setName("Java Class");

        classRoomDAO.createClassRoom(c);

        // Create Student
        Student s = new Student();
        s.setName("Nguyen Van A");
        s.setAge(20);
        s.setClassRoom(c);

        studentDAO.createStudent(s);

        // Read Student
//        System.out.println("\n**Tạo thành công student có tên: " + studentDAO.findById(s.getId()).getName() + "\n");

        // Update Student
        s.setAge(21);
        studentDAO.updateStudent(s);
        System.out.println("\n**Cập nhật tuổi thành công cho student " + studentDAO.findById(s.getId()) + "\n");

        // Delete Student
        studentDAO.deleteStudent(s.getId());

//        System.out.println("\n**Xóa thành công student có id=" + s.getId() + "\n");
        System.out.println("\n**Tìm student id=" + s.getId() + ": " + studentDAO.findById(s.getId()) + "\n");
        System.out.println("\n**Danh sách sinh viên: " + studentDAO.findAll());

//        Student s2 = new Student();
//        // để trống tên
//        s2.setAge(200);
//        s2.setClassRoom(c);
//        studentDAO.createStudent(s2);

        em.close();
        emf.close();
    }
}
