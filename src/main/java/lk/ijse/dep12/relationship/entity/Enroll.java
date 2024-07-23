package lk.ijse.dep12.relationship.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "enroll")
@IdClass(EnrollPK.class)
public class Enroll implements Serializable {
    @Id
    @ManyToOne
    @JoinColumn(name ="student_id",referencedColumnName = "id")
//    @MapsId("studentId")
    private Student student;
    @Id
    @ManyToOne
    @JoinColumn(name ="course_code",referencedColumnName = "code")
//    @MapsId("courseCode")
    private Course course;

    @Column(name = "registered_by")
    private String registeredBy;
    private Date date;


//    public Enroll( String registeredBy, Date date, Student student, Course course) {
//        this.enrollPK = new EnrollPK(student.getId(),course.getCode());
//        this.registeredBy = registeredBy;
//        this.date = date;
//        this.student = student;
//        this.course = course;
//    }

}
