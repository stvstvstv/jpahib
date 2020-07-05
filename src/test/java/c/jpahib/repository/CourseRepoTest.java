package c.jpahib.repository;


import c.jpahib.JpahibApplication;
import c.jpahib.entity.Course;
import c.jpahib.entity.Student;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest(classes = JpahibApplication.class)
public class CourseRepoTest {

    @Autowired
    CourseRepo repo;

    @Autowired
    EntityManager em;

    @Test
    public void repoFindsSomething(){
        Course course = repo.findById(10001L);
        assertEquals( "jpa in 50 steps", course.getName());
    }

    @Test @DirtiesContext
    public void testDeleteByID(){
        repo.deleteById(10002L);
        assertNull( repo.findById( 10002L ) );
    }


    @Test
    @Transactional
    public void testuletz(){
        Course course = em.find(Course.class, 10001L);
        System.out.println("CURS!"+ course.toString() );
        System.out.println("CURS + STUD " + course.getStudents());
    }

    @Test
    @Transactional
    public void testuletz2(){
        Student student = em.find(Student.class, 20001L);

        System.out.println("@@@@@STUDENT : " + student);;

    }

    @Test
    @Transactional
    public void testuletz3(){
        Student student = em.find(Student.class, 20001L);
        System.out.println("@@@@@STUDENT : " + student);;
        student.getReviews().forEach( review -> {
            System.out.println( "~~~~~ review : " + review + "\n student: " + review.getStudent()  + " \n course " + review.getCourse() );
        });

    }
}
