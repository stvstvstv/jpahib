package c.jpahib.repository.hierarchy;

import c.jpahib.entity.hierarchy.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@Transactional
public class EmployeeRepo {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    EntityManager em;

    public Employee findById(Long id ){
        return em.find( Employee.class, id );
    }

    public void insert( Employee employee ) {
        em.persist( employee );
    }

    public List<Employee> findAllEmployees(){
        return em.createQuery( "SELECT e FROM Employee e", Employee.class )
                .getResultList();
    }

}
