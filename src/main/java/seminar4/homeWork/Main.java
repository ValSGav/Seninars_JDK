package seminar4.homeWork;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        DictionaryEmployees testDict = new DictionaryEmployees();
        try {
            testDict.addEmployee(1, "Ivan", "Leskov", 3222222, "03-04-1982", 5);
            testDict.addEmployee(2, "Ivan", "Pushkov", 7776622, "05-07-1952", 25);
            testDict.addEmployee(3, "Sonya", "Gu", 5770011, "23-11-1992", 3);
            testDict.addEmployee(4, "Lelik", "Bolikov", 8924231, "17-08-2001", 1);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        ArrayList<Integer> phoneNumbersOfIvan = testDict.getTelephoneNumber("Ivan");
        ArrayList<Integer> phoneNumbersOfTural = testDict.getTelephoneNumber("Tural");

        HashMap<Integer, Employee> employeesOver5YearsExperience = testDict.getEmployeeByExperience(5);

        Employee employeeServiceNumber3 = testDict.getEmployeeByServiceNumber(3);


        for (Integer phoneNumber : phoneNumbersOfIvan) {
            System.out.println("Ivan phone number: " + phoneNumber);
        }

        for (Integer phoneNumber : phoneNumbersOfTural) {
            System.out.println("Tural phone number: " + phoneNumber);
        }

        System.out.println("Employees over 5 year experience is:");
        for (Map.Entry<Integer, Employee> entryEmployee : employeesOver5YearsExperience.entrySet()) {
            System.out.println(entryEmployee.getValue());
        }

        System.out.println("Employee with service number 3 is:");
        System.out.println(employeeServiceNumber3);


    }
}
