package seminar4.homeWork;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Employee {
    private final int serviceNumber;
    private final int telephoneNumber;
    private final Date dateBirth;
    private final int experience;
    private final String name;
    private final String lastName;


    public int getTelephoneNumber() {
        return telephoneNumber;
    }

    public String getName() {
        return name;
    }

    public Employee(String name
            , String lastName
            , int serviceNumber
            , int telephoneNumber
            , String dateBirth
            , int experience) throws ParseException {
        this.serviceNumber = serviceNumber;
        this.telephoneNumber = telephoneNumber;
        DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        this.dateBirth = formatter.parse(dateBirth);
        this.experience = experience;
        this.name = name;
        this.lastName = lastName;
    }

    public int getAge(Date currentDate) {

        DateFormat formatter = new SimpleDateFormat("yyyyMMdd");
        int d1 = Integer.parseInt(formatter.format(dateBirth));
        int d2 = Integer.parseInt(formatter.format(currentDate));
        return (d2 - d1) / 10000;

    }

    public int getExperience() {
        return experience;
    }

    @Override
    public String toString() {
        return String.format("sn. %d - %s %s; (tel.) %d; age %d", serviceNumber, name, lastName, telephoneNumber, getAge(new Date()));
    }
}
