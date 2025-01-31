package streams.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class TestSortCollect {

    public static void main(String[] args) {

        List<Hosting> list = new ArrayList<>();
        list.add(new Hosting(1, "liquidweb.com", 80000));
        list.add(new Hosting(2, "linode.com", 90000));
        list.add(new Hosting(3, "digitalocean.com", 120000));
        list.add(new Hosting(4, "aws.amazon.com", 200000));
        list.add(new Hosting(5, "mkyong.com", 1));
        list.add(new Hosting(6, "linode.com", 100000));

        Collections.sort(list, Comparator.comparing(Hosting::getName).thenComparingLong(Hosting::getWebsites));
        list.stream().forEach(System.out::println);
    }
}

class Hosting implements Comparable<Hosting> {

    private int Id;
    private String name;
    private long websites;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getWebsites() {
        return websites;
    }

    public void setWebsites(long websites) {
        this.websites = websites;
    }

    public Hosting(int id, String name, long websites) {
        Id = id;
        this.name = name;
        this.websites = websites;
    }

    @Override
    public int compareTo(Hosting h) {
        return this.name.compareTo(h.name);
    }

    @Override
    public String toString() {
        return "Hosting{" +
                "Id=" + Id +
                ", name='" + name + '\'' +
                ", websites=" + websites +
                '}';
    }

    //getters, setters and toString()
}