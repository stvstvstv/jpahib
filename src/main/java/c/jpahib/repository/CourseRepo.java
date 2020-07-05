package c.jpahib.repository;

import c.jpahib.entity.Course;
import c.jpahib.entity.Review;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@Transactional
public class CourseRepo {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    EntityManager em;

    public Course findById( Long id ){
        return em.find( Course.class, id );
    }

    public void deleteById( Long id ){
        Course course = findById( id );
        em.remove( course );
    }

    public Course saveBy( Course course ) {
        if ( course.getId() == null ) {
            em.persist( course );
        } else {
            em.merge(course);
        }
        return course;
    }

    public void play(){
        Course course1 = new Course("course1");
        Course course2 = findById( 10001L);
        em.persist( course1 );

        course2.setName("course2-updated");
    }

    public void addReviewsForCourse( Long courseId, List<Review> reviews ) {
        Course course = findById( courseId );
        logger.info("course.getReviews{}", course.getReviews());

        reviews.forEach( review -> {
            course.addReview( review );
            review.setCourse( course );
            em.persist( review );
        });

    }
//    public void addReviewsForCourse() {
//        Course course = findById(10003L);
//        logger.info("course.getReviews{}", course.getReviews());
//
//        Review review1 = new Review( "blanao", "****");
//        Review review2 = new Review( "n1", "*****");
//
//        course.addReview( review1 );
//        course.addReview( review2 );
//
//        review1.setCourse( course );
//        review2.setCourse( course );
//
//        em.persist( review1 );
//        em.persist( review2 );
//
//    }
}
