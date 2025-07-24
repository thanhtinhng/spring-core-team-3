package org.example.ORM.hibernate;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class ClassRoomDAO {
    private EntityManager entityManager;    // khởi tạo EntityManager – đối tượng trung tâm để thao tác với database trong JPA

    public ClassRoomDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

//      persist() – thêm mới
//      find() – truy vấn theo ID
//      merge() – cập nhật
//      remove() – xoá
//      docs: https://docs.oracle.com/javaee/7/api/javax/persistence/EntityManager.html

    public void createClassRoom(ClassRoom classRoom) {
        EntityTransaction tx = entityManager.getTransaction();
        try {
            // Bắt đầu transaction để lưu classRoom vào DB
            tx.begin();
            entityManager.persist(classRoom);
            // Kết thúc
            tx.commit();
        } catch (RuntimeException e) {
            if (tx.isActive()) tx.rollback();
            throw e;
        }
    }


}