package test.dsa.sort;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import java.util.Comparator;
import java.util.PriorityQueue;

/*
 * Create the Student and Priorities classes here.
 *
 * Testcase:1
12
ENTER John 3.75 50
ENTER Mark 3.8 24
ENTER Shafaet 3.7 35
SERVED
SERVED
ENTER Samiha 3.85 36
SERVED
ENTER Ashley 3.9 42
ENTER Maria 3.6 46
ENTER Anik 3.95 49
ENTER Dan 3.95 50
SERVED
 *
 */
class Student implements Comparable<Student> {
    int id;
    String name = "";
    double cgpa;
    Student(String name, double cgpa, int id) {
        this.id = id;
        this.name = name;
        this.cgpa = cgpa;
    }

    public String getName() {
        return this.name;
    }

    public double getCgpa() {
        return this.cgpa;
    }

    public int getId() {
        return this.id;
    }

    @Override
    public int compareTo(Student s) {
        //  int cmpScore = this.cgpa.compareTo(s.cgpa);
        //  int cmpName = 0;
        //  int cmpId = 0;

        //  if (cmpScore == 0) {
        //      cmpName = this.name.compareTo(s.name);
        //      if (cmpName == 0) {
        //          cmpId = this.id.compareTo(s.id);
        //      }
        //  }

        return Comparator.comparingDouble(Student::getCgpa)
                .thenComparing(Student::getName)
                .thenComparingInt(Student::getId)
                .compare(this, s);
    }
}

class Priorities {
    public ArrayList<Student> getStudents(List<String> events)
    {
        int n = events.size();
        PriorityQueue<Student> pq = new PriorityQueue<>();
        for(String i:events)
        {
            String[] s = i.split("\\s");
            if(s.length > 1)
            {
                pq.add(new Student(
                        s[1],
                        Double.valueOf(s[2]),
                        Integer.valueOf(s[3])
                ));
            } else {
                pq.poll();
            }
        }

        return new ArrayList<Student>(pq);
    }
}


public class PrioritiesQueue {
    private final static Scanner scan = new Scanner(System.in);
    private final static Priorities priorities = new Priorities();

    public static void main(String[] args) {
        int totalEvents = Integer.parseInt(scan.nextLine());
        List<String> events = new ArrayList<>();

        while (totalEvents-- != 0) {
            String event = scan.nextLine();
            events.add(event);
        }

        List<Student> students = priorities.getStudents(events);

        if (students.isEmpty()) {
            System.out.println("EMPTY");
        } else {
            for (Student st: students) {
                System.out.println(st.getName());
            }
        }
    }
}