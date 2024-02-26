package seminar4.homeWork;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DictionaryEmployees {
    HashMap<Integer, Employee> dictionary;

    public DictionaryEmployees() {
        dictionary = new HashMap<>();
    }

    public void addEmployee(int serviceNumber, String name, String lastName, int telephoneNumber, String dateOfBirth, int experience) throws Exception {
        Employee newEmployee = new Employee(name, lastName, serviceNumber, telephoneNumber, dateOfBirth, experience);
        dictionary.put(serviceNumber, newEmployee);
    }

    public Employee getEmployeeByServiceNumber(int serviceNumber) {
        return dictionary.get(serviceNumber);
    }

    public HashMap<Integer, Employee> getEmployeeByExperience(int experience) {
        HashMap<Integer, Employee> returnHashMap = new HashMap<>();
        for (Map.Entry<Integer, Employee> employeeEntry : dictionary.entrySet()) {
            if (employeeEntry.getValue().getExperience() >= experience) {
                returnHashMap.put(employeeEntry.getKey(), employeeEntry.getValue());
            }
        }
        return returnHashMap;
    }

    public ArrayList<Integer> getTelephoneNumber(String name) {
        ArrayList<Integer> resultList = new ArrayList<>();
        for (Map.Entry<Integer, Employee> employeeEntry : dictionary.entrySet()) {
            if (employeeEntry.getValue().getName().equals(name)) {
                resultList.add(employeeEntry.getValue().getTelephoneNumber());
            }
        }
        return resultList;
    }
}
