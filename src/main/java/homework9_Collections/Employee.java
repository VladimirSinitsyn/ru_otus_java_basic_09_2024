package homework9_Collections;

import java.util.ArrayList;
import java.util.List;

public class Employee {
    private String firstName;
    private String lastName;
    private int age;

    public Employee(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public String getFirstName() {
        return firstName;
    }

    @Override
    public String toString() {
        return   firstName + " "+
                 lastName +  " "+
                 age;
    }

    public static List<String> returnFirstNames(List<Employee> employees) {
        List<String> firstNames = new ArrayList<>();
        for (Employee employee : employees) {
            firstNames.add(employee.getFirstName());
        }
        System.out.println(firstNames);
        return firstNames;
    }
    public static List<Employee> ageFilterByMinAge (int minAge, List<Employee>employees) {
        List<Employee> employeeListByMinAge = new ArrayList<>();
        for (Employee employee : employees) {
            if (employee.getAge() >= minAge) {
                employeeListByMinAge.add(employee);
            }
        }
        return employeeListByMinAge;
    }
    public static boolean checkByMinAverageAge (int minAverageAge, List<Employee>employees) {
int sumOfAllAge = 0;
int count = 0;
        for (Employee employee : employees) {
    sumOfAllAge += employee.getAge();
    count++;
}
        Double averageAge = (double)sumOfAllAge/count;
        return  averageAge>=minAverageAge;
    }

    public static Employee youngestEmployee (List<Employee> employees) {
        Employee youngestEmployee = employees.get(0);
                for (Employee employee : employees) {
            if (employee.getAge() < youngestEmployee.getAge()) {
                youngestEmployee = employee;
            }
        }
return youngestEmployee;
    }

    private static List<Employee> generateList(){
        List<Employee> result= new ArrayList<>();
        result.add(new Employee("Иван", "Иванов", 30));
        result.add(new Employee("Cергей", "Сергеев", 25));
        result.add(new Employee("Пётр", "Петров", 35));
        result.add(new Employee("Елена", "Еленовна", 20));
        result.add(new Employee("Максим", "Максимов", 40));
        return result;
    }

    public static void main(String[] args) {

        List<Employee> employees = generateList();
        returnFirstNames(generateList());
        System.out.println(ageFilterByMinAge(35, employees));
        System.out.println(checkByMinAverageAge(20, employees));
        System.out.println(youngestEmployee(employees));
    }
}
