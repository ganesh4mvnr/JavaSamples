package test.dsa;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Ganesan Marimuthu
 */
public class TestEmpCode {

    public static void main(String[] args) {
        Company c1 = new Company("Facebook");
        Employee emp1 = new Employee("xyz", 10);
        Employee emp2 = new Employee("hji", 40);
        Employee emp3 = new Employee("abc", 20);
        c1.setEmployeeList(Stream.of(emp1,emp2,emp3).collect(Collectors.toList()));

        Company c2 = new Company("Facebook");
        Employee emp4 = new Employee("xyz", 10);
        Employee emp5 = new Employee("mno", 40);
        Employee emp6 = new Employee("abc", 20);
        c2.setEmployeeList(List.of(emp1,emp2,emp3,emp4,emp5,emp6));

        List<Company> companies = new ArrayList<>();
        companies.add(c1);
        companies.add(c2);
        
        List<Employee> employees = List.of(emp1,emp2,emp3,emp4,emp5,emp6);

        /**
        Comparator<Employee> comparator = Comparator.comparing(Employee::getName).thenComparing(Employee::getAge);
        //Comparator cmp = (test.dsa.Employee emp11, test.dsa.Employee emp22) -> Integer.compare(emp11.getAge(), emp22.getAge());
        List<Employee> result = employees.stream().sorted(comparator).collect(Collectors.toList());
        result.stream().map(e -> e.getName()).forEach(System.out::println);

        List<Stream<Employee>> resultComp = companies.stream().map(c -> c.getEmployeeList().stream()
                .filter(employee -> employee.getAge() > 20)).collect(Collectors.toList());
        resultComp.stream().forEach(employeeStream -> {
            System.out.println("This is printing");
            employeeStream.forEach(emp11 -> emp11.getName());
        });
         **/

        List<Employee> uniqueEmpList = employees.parallelStream().distinct()
                .collect(Collectors.toUnmodifiableList());
        System.out.println("Unique Employees list.... ");
        uniqueEmpList.forEach(employee ->
                System.out.println("Emp name: " + employee.getName() + " & Age = " + employee.getAge()));
    }

    public static <T> Predicate<T> distinctBy(Function<? super T, ?> f) {
        Set<Object> objects = new HashSet<>();
        return t -> objects.add(f.apply(t));
    }
}


class Company {

    public Company(String name) {
        this.orgName = name;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String orgName;

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    public List<Employee> employeeList;
}

class Employee {
    private String name;
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        Employee employee = (Employee) o;
        return name.equals(employee.name) && age.equals(employee.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}

/**
class Employee implements Comparable<Employee> {
    private String name;
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public int compareTo(Employee emp1) {
        return this.name.compareTo(emp1.getName());
    }
}
 **/
