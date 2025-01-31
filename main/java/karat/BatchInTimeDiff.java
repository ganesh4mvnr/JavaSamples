package karat;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

/**
 We are working on a security system for a badged-access room in our company's building.

 We want to find employees who badged into our secured room unusually often. We have an unordered list of names and entry times over a single day. Access times are given as numbers up to four digits in length using 24-hour time, such as "800" or "2250".

 Write a function that finds anyone who badged into the room three or more times in a one-hour period. Your function should return each of the employees who fit that criteria, plus the times that they badged in during the one-hour period. If there are multiple one-hour periods where this was true for an employee, just return the earliest one for that employee.

 badge_times = [
 ["Paul",      "1355"], ["Jennifer",  "1910"], ["Jose",    "835"],
 ["Jose",       "830"], ["Paul",      "1315"], ["Chloe",     "0"],
 ["Chloe",     "1910"], ["Jose",      "1615"], ["Jose",   "1640"],
 ["Paul",      "1405"], ["Jose",       "855"], ["Jose",    "930"],
 ["Jose",       "915"], ["Jose",       "730"], ["Jose",    "940"],
 ["Jennifer",  "1335"], ["Jennifer",   "730"], ["Jose",   "1630"],
 ["Jennifer",     "5"], ["Chloe",     "1909"], ["Zhang",     "1"],
 ["Zhang",       "10"], ["Zhang",      "109"], ["Zhang",   "110"],
 ["Amos",         "1"], ["Amos",         "2"], ["Amos",    "400"],
 ["Amos",       "500"], ["Amos",       "503"], ["Amos",    "504"],
 ["Amos",       "601"], ["Amos",       "602"], ["Paul",   "1416"]
 ];

 Expected output (in any order)
 Paul: 1315 1355 1405
 Jose: 830 835 855 915 930
 Zhang: 10 109 110
 Amos: 500 503 504

 n: length of the badge records array

 **/


public class BatchInTimeDiff {
    public static void main(String[] argv) {
        /**String[][] badgeTimes = new String[][] {
                {"Paul", "1355"},
                {"Jennifer", "1910"},
                {"Jose", "835"},
                {"Jose", "830"},
                {"Paul", "1315"},
                {"Chloe", "0"},
                {"Chloe", "1910"},
                {"Jose", "1615"},
                {"Jose", "1640"},
                {"Paul", "1405"},
                {"Jose", "855"},
                {"Jose", "930"},
                {"Jose", "915"},
                {"Jose", "730"},
                {"Jose", "940"},
                {"Jennifer", "1335"},
                {"Jennifer", "730"},
                {"Jose", "1630"},
                {"Jennifer", "5"},
                {"Chloe", "1909"},
                {"Zhang", "1"},
                {"Zhang", "10"},
                {"Zhang", "109"},
                {"Zhang", "110"},
                {"Amos", "1"},
                {"Amos", "2"},
                {"Amos", "400"},
                {"Amos", "500"},
                {"Amos", "503"},
                {"Amos", "504"},
                {"Amos", "601"},
                {"Amos", "602"},
                {"Paul", "1416"},
        };
         **/

        String[][] badgeTimes = new String[][] {
                {"Paul", "1355"},
                {"Jennifer", "1910"},
                {"Paul", "1315"},
                {"Paul", "1405"},
                {"Paul", "1416"},
        };

        BatchInTimeDiff db = new BatchInTimeDiff();
        System.out.println(db.getMaxBatchInPersons(badgeTimes));
    }

    public Map<String, LinkedList<Integer>> getMaxBatchInPersons(String[][] badgeTimes) {
        Map<String, LinkedList<Integer>> result = new HashMap<>();
        int arrLen = badgeTimes.length;
        int min = 0;

        for (int i=0; i < arrLen; i++) {
            String name = badgeTimes[i][0];
            LinkedList<Integer> timeList = result.get(name);
            if (timeList == null) {
                timeList = new LinkedList<>();
            }
            min = convertToMin(badgeTimes[i][1]);
            timeList.add(min);
            result.put(name, timeList.stream().sorted().collect(Collectors.toCollection(LinkedList::new)));
        }

        filterMaxBatchInPersons(result);

        return result;
    }

    public void filterMaxBatchInPersons(Map<String, LinkedList<Integer>> badegeTimesMap) {
        for (String person: badegeTimesMap.keySet()) {
            LinkedList<Integer> filteredTimesList = new LinkedList<>();
            LinkedList<Integer> timesList = badegeTimesMap.get(person);
            int prevNum = 0;
            Iterator<Integer> itr = timesList.iterator();
            while (itr.hasNext()) {
                Integer number = itr.next();
                if (compareInt(prevNum, number) == 1) {
                    filteredTimesList.add(prevNum);
                }
                prevNum = number;
            }
            badegeTimesMap.put(person, filteredTimesList);
        }
    }

    public int compareInt(int num1, int num2) {
        int diff = num2 - num1;
        if (diff > 61) {
            return -1;
        }
        return 1;
    }


    public int convertToMin(String time) {
        // 510
        int timeInt = Integer.parseInt(time);
        int hour = timeInt / 100;
        int min = timeInt % 100;

        return hour * 60 + min;
    }
}
