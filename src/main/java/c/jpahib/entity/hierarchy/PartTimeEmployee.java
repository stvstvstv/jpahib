package c.jpahib.entity.hierarchy;

import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity
public class PartTimeEmployee extends Employee {

    private BigDecimal hourlyWage;

    public PartTimeEmployee() { }

    public PartTimeEmployee(String name, BigDecimal hourlyWage) {
        super( name );
        this.hourlyWage = hourlyWage;
    }
}
