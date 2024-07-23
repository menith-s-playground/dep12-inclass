package lk.ijse.dep12.relationship.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "enroll")
public class Enroll implements Serializable {
    @EmbeddedId
    private EnrollPK enrollPK;
    @Column(name = "registered_by")
    private String registeredBy;
    private Date date;

    @ManyToOne
    @JoinColumn(name = "student_id",referencedColumnName = "id" ,insertable = false,updatable = false)
    private Student student;

    @ManyToOne
    @JoinColumn(name = "course_code",referencedColumnName = "code" ,insertable = false,updatable = false)
    private Course course;

    public Enroll( String registeredBy, Date date, Student student, Course course) {
        this.enrollPK = new EnrollPK(student.getId(),course.getCode());
        this.registeredBy = registeredBy;
        this.date = date;
        this.student = student;
        this.course = course;
    }

}
