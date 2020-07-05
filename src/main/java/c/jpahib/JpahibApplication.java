package c.jpahib;

import c.jpahib.entity.Course;
import c.jpahib.entity.Review;
import c.jpahib.entity.Student;
import c.jpahib.repository.CourseRepo;
import c.jpahib.repository.StudentRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.util.CollectionUtils;

import java.util.Arrays;

@SpringBootApplication
public class JpahibApplication implements CommandLineRunner {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private CourseRepo courseRepo;
    @Autowired
    private StudentRepo studentRepo;


    public static void main(String[] args) {
        SpringApplication.run(JpahibApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//        studentRepo.saveStudentWithPassport();
        //        courseRepo.play();

//        Review review = new Review("nais", "*");
//        Review review2 = new Review("noice", "**");
//
//        courseRepo.addReviewsForCourse(10003L, Arrays.asList( review, review2));
        Student student = new Student("John");
        Course course = new Course("microservicii");
        studentRepo.insertStudentAndCourse(student, course);
    }
}
