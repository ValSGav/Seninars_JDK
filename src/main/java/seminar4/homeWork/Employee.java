package seminar4.homeWork;

import java.time.Duration;
import java.time.LocalDate;
import java.util.Date;

public class Employee {
    private final int serviceNumber;
    private final int telephoneNumber;
    private final LocalDate dateBirth;
    private final int expirence;
    private final String name;

    public Employee(String name, int serviceNumber, int telephoneNumber, String dateBirth, int expirence) {
        this.serviceNumber = serviceNumber;
        this.telephoneNumber = telephoneNumber;
        this.dateBirth = LocalDate.parse(dateBirth);
        this.expirence = expirence;
        this.name = name;
    }

    public int getAge(Date currentDate){
        return Duration.between(currentDate.toLocal)this.dateBirth -
    }
}
