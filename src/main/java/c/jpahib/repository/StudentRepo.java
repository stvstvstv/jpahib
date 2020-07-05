package c.jpahib.repository;

import c.jpahib.entity.Course;
import c.jpahib.entity.Passport;
import c.jpahib.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@Repository
@Transactional
public class StudentRepo {

    @Autowired
    EntityManager em;

    public Student findById( Long id ){
        return em.find( Student.class, id );
    }

    public void deleteById( Long id ){
        Student student = findById( id );
        em.remove( student );
    }

    public Student saveBy( Student student ) {
        if ( student.getId() == null ) {
            em.persist( student );
        } else {
            em.merge(student);
        }
        return student;
    }

    public void saveStudentWithPassport(){
        Passport passport = new Passport("pulamea");
        em.persist( passport );

        Student student = new Student( "Mike" );

        em.persist( passport );
        student.setPassport( passport );

        em.persist( student );

    }
    public void insertStudentAndCourse(Student student, Course course){
        student.addCourse( course );
        course.addStudent( student );

        em.persist(student);
        em.persist(course);
    }


//    public void insertStudentAndCourse(){
//        Student student = new Student("John");
//        Course course = new Course("microservicii");
//        em.persist(student);
//        em.persist(course);
//        student.addCourse( course );
//        course.addStudent( student );
//    }
}
