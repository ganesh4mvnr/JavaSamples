import java.util.*;
import java.util.function.*;
import java.util.stream.*;

public class MyClass {
    public static void main(String[] args) {
        List<Foo> foos = new ArrayList<>();
        foos.add(new Foo("A", 1, 10));
        foos.add(new Foo("A", 2, 10));
        foos.add(new Foo("A", 3, 10));
        foos.add(new Foo("B", 1, 10));
        foos.add(new Foo("C", 1, 10));
        foos.add(new Foo("C", 5, 10));
    
        List<Foo> summarized = new ArrayList<>();
        Map<Foo, List<Foo>> collect = foos.stream().collect(Collectors.groupingBy(new Function<Foo, Foo>() {
            @Override
            public Foo apply(Foo t) {
                Optional<Foo> fOpt = summarized.stream().filter(e -> e.getCategory().equals(t.getCategory())).findFirst();
                Foo f;
                if (!fOpt.isPresent()) {
                    f = new Foo(t.getCategory(), 0, 0);
                    summarized.add(f);
                } else {
                    f = fOpt.get();
                }
                f.setAmount(f.getAmount() + t.getAmount());
                f.setPrice(f.getPrice() + t.getPrice());
                return f;
            }
        }));
        System.out.println(collect);
    }
}

class Foo {
    private String category;
    private int amount;
    private int price;

    Foo(String category, int amount, int price) {
        this.category = category;
        this.amount = amount;
        this.price = price;
    }
    public void setCategory(String c) {
        this.category = c;
    }
    
    public void setAmount(int c) {
        this.amount = c;
    }
    
    public void setPrice(int c) {
        this.price = c;
    }
    
    public int getPrice() {
        return this.price;
    }
    
    public String getCategory() {
        return this.category;
    }
    
    public int getAmount() {
        return this.amount;
    }
    
    public String toString() {
        String str = this.getCategory() + " " + this.getAmount() + " " + this.getPrice();
        return str;
    }
}