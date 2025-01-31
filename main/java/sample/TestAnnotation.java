package sample;

import java.lang.annotation.*;
import java.util.Arrays;

public class TestAnnotation {
    public static void main(String[] args) throws NoSuchFieldException {
        Annotation[] annotations = Person.class.getDeclaredField("name").getDeclaredAnnotations();
        Arrays.stream(annotations).forEach(annotation -> System.out.println("annotation = " + annotation));
    }
}

@MyAnnotation("Person")
class Person {
    private String name;

    public String getName() {return name;}
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface MyAnnotation {
    String value();
}
