package test.dsa.sort;

import java.util.*;
import java.util.stream.Collectors;

public class WordSort {
    public static void main(String[] argv) {
        String[] counts = {
                "POINT,333858038",
                "NOT,4522732626",
                "INTO,1144226142",
                "ON,4594521081",
                "FOR,6545282031",
                "NOW,679337516",
                "ONE,2148983086",
                "BEHAVIOR,104177552",
                "WAITS,2911079",
                "PEOPLE,658716166",
                "HI,15453893",
                "FORM,352032932",
                "OF,30966074232",
                "THROUGH,647091198",
                "BETWEEN,744064796",
                "FOUR,262968583",
                "LEFT,306802162",
                "OFF,302535533",
                "FROM,3469207674",
                "NO,1400645478",
                "FORMS,136468034",
                "A,45916054218"
        };

        get_list(counts, 15, 5);
    }

    public static String[] get_list(String[] counts, int maxWords, int wordLen) {
        List<String> result = new ArrayList<>();
        Map<Integer, Employee> employeeMap = new HashMap<>();
        employeeMap.put(10, new Employee("TEST"));
        employeeMap.put(30, new Employee("AT"));
        employeeMap.put(20, new Employee("ABD"));
        employeeMap.put(40, new Employee("QBD"));
        employeeMap.put(50, new Employee("MQTT"));


        Map<String, Long> newWordMap = Arrays.stream(counts).map(word -> word.split(","))
                .collect(Collectors.toMap(e -> e[0], e -> Long.parseLong(e[1])));
        System.out.println("newWordMap: \n" + newWordMap);

        Map<String, Long> sortedWordMap = newWordMap.entrySet().stream().limit(maxWords)
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

        //sortedWordMap.entrySet().stream().collect(Collectors.toList())
        //        .sort(Comparator.comparingLong(Map.Entry::getValue));

        sortedWordMap.keySet().forEach(word -> {
            result.add(new StringBuilder(word).append(':').append(sortedWordMap.get(word)).toString());
        });

        System.out.println("------ Result string. ");
        result.stream().forEach(System.out::println);

        Map<Integer, Employee> newEmployeeMap = new LinkedHashMap<>();
        employeeMap.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.comparing(Employee::getName)))
                .forEachOrdered(x -> newEmployeeMap.put(x.getKey(), x.getValue()));
        System.out.println(newEmployeeMap);

        return result.toArray(new String[result.size()]);
    }
}

class Employee {
    public Employee(String n) {
        this.name = n;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String name;

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                '}';
    }
}
