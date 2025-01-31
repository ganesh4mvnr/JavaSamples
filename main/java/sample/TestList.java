package sample;

import org.apache.commons.collections4.CollectionUtils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class TestList {
    public static void main(String[] args) throws ParseException {
        List<List<Integer>> result = new ArrayList<>();
        List<String> myList = List.of(String.format("%s:%d", "abc", 8900));

        System.out.println("myList = " + myList);

        List<String> aList = List.of("AXD");
        List<String> another = new ArrayList<>();
        //if (!CollectionUtils.isEmpty(another))
            aList.addAll(another);

        System.out.println("another List = " + aList);

        result.addAll(Collections.singleton(List.of(100)));
    }

}
