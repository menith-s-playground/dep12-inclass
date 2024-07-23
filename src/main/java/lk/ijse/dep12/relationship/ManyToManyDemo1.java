package lk.ijse.dep12.relationship;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import lk.ijse.dep12.relationship.entity.Course;
import lk.ijse.dep12.relationship.entity.Enroll;
import lk.ijse.dep12.relationship.entity.EnrollPK;
import lk.ijse.dep12.relationship.entity.Student;
import lk.ijse.dep12.relationship.util.JpaUtil;

import java.sql.Date;
import java.time.LocalDate;

public class ManyToManyDemo1 {

    public static void main(String[] args) {
        try (EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();
             EntityManager em = emf.createEntityManager()) {
            EntityTransaction tx = em.getTransaction();
            try {
                tx.begin();
                Student e001 = em.find(Student.class, "E001");
                Course c001 = em.find(Course.class, "C001");
                Enroll l1 = new Enroll(e001, c001,"Lahiru", Date.valueOf(LocalDate.now()));

                em.persist(l1);
                tx.commit();
            } catch (Throwable e) {
                tx.rollback();
                e.printStackTrace();
            }
        }
    }
}