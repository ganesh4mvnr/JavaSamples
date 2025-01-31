import java.util.*;
import java.util.stream.*;
import java.util.function.Predicate;
 
public class MatchDemo {
 
    private static void matchingWithStreams() {
 
        Predicate<Employee> p1 = e -> e.id < 10 && e.name.startsWith("A");
        Predicate<Employee> p2 = e -> e.sal < 10000;

        List<String> namesList = List.of("A", "E");
        List<Employee> eList = Employee.getEmpList();
        List<Employee> xList = new ArrayList<>();
        xList.add(new Employee(1, "A", 2000));
        xList.add(new Employee(2, "B", 3000));
        xList.add(new Employee(3, "C", 4000));
        xList.add(new Employee(4, "D", 5000));
        xList.add(new Employee(5, "E", 12000));
        xList.add(new Employee(10, "F", 25000));

        /***** Example #1 - Using 'allMatch' *****/
        boolean b1 = eList.stream().allMatch(p1);

        List<Employee> result = xList.stream().filter(x ->
                                eList.stream().noneMatch(e -> e.id == x.id))
            .collect(Collectors.toList());
        System.out.println("None match::");
        result.forEach(e1 -> System.out.println(e1.name));
        
        result = xList.stream().filter(x ->
                                eList.stream().allMatch(e -> e.id == x.id))
            .collect(Collectors.toList());
        System.out.println("All match::");
        result.forEach(e1 -> System.out.println(e1.name));
        
        result = xList.stream().filter(x ->
                                eList.stream().anyMatch(e -> {
                                    if (e.id == x.id) {
                                        x.name+="**";
                                        return true;
                                    }
                                    return false;
                                    }))
            .collect(Collectors.toList());
        System.out.println("Any match::");
        result.forEach(e1 -> System.out.println(e1.name));
 
        boolean b2 = eList.stream().allMatch(p2);
        //System.out.println("All employees having 'esalary<10000'?= " + b2 + "\n");
 
        /***** Example #2 - Using 'anyMatch' *****/
        boolean b3 = eList.stream().anyMatch(p1);
        //System.out.println("Any employee having 'eid<10' & 'ename.equalsIgnoreCase('A')'?= " + b3 + "\n");
 
        boolean b4 = eList.stream().anyMatch(p2);
        //System.out.println("Any employee having 'esalary<10000'?= " + b4 + "\n");
 
        /**** Example #3 - Using 'noneMatch' *****/
        boolean b5 = eList.stream().noneMatch(p1);
        //System.out.println("No employee having 'esalary<10000'?= " + b5);
    }
 
    public static void main(String[] args) {
        matchingWithStreams();
    }   
}

class Employee {
 
    public int id, sal;
    public String name;
 
    public Employee() { }
 
    public Employee(int id, String name, int sal) {
        this.id = id;
        this.name = name;
        this.sal = sal;
    }
 
    public static List<Employee> getEmpList() {
        List<Employee> empList = new ArrayList<Employee>();
        empList.add(new Employee(1, "A", 2000));
        empList.add(new Employee(2, "B", 3000));
        empList.add(new Employee(3, "C", 4000));
        empList.add(new Employee(4, "D", 5000));
        return empList;
    }
}
