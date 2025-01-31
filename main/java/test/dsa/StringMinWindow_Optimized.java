package test.dsa;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StringMinWindow_Optimized {

	  public static String minWindow(String s, String t) {
		  
		  int r = 0, l = 0;
		  int mainStrLen = s.length();
		  int count = 0;
		  Map<Character, Integer> t_charMap = new HashMap<>();
		  List<MyCharMap> filteredList = new ArrayList<>();
		  Map<Character, Integer> windowCount = new HashMap<>();
		  int formed = 0;
		  int resLen = -1;
		  int stIdx = 0, endIdx = 0;

		  for (int i=0;i<t.length();i++) {
			  count = t_charMap.getOrDefault(t.charAt(i), 0);
			  t_charMap.put(t.charAt(i), count + 1);
		  }
		  
		  for (int i=0;i<mainStrLen;i++) {
			  char ch = s.charAt(i);
			  if (t_charMap.containsKey(ch)) {
				  MyCharMap myCharMap = new MyCharMap(i, ch);
				  filteredList.add(myCharMap);
			  }
		  }
		  
		  while(r < filteredList.size()) {
			  char c = filteredList.get(r).ch;
			  int val = windowCount.getOrDefault(c, 0);
			  windowCount.put(c, val + 1);
			  
			  if (t_charMap.containsKey(c) && t_charMap.get(c).intValue() == windowCount.get(c).intValue())
				  formed++;
			  
			  while (l <= r && formed == t.length()) {
				  c = filteredList.get(l).ch;
				  int start = filteredList.get(l).i;
				  int end = filteredList.get(r).i;
				  if (resLen == -1 || end-start + 1 < resLen) {
					  resLen = end-start + 1;
					  stIdx = start;
					  endIdx = end;
				  }
				  
				  windowCount.put(c, windowCount.get(c) - 1);
				  if (t_charMap.containsKey(c) && windowCount.get(c).intValue() < t_charMap.get(c).intValue()) {
					  formed--;
				  }
				  
				  l++;
			  }
			  r++;
		  }
		  
		  if (resLen == -1) {
			  return "";
		  }

	      return s.substring(stIdx, endIdx + 1);
	  }
	  
	  public static void main(String[] args) {
		  String s = "ADACBDEA";
		  String t = "ABC";
		  System.out.println("minWindow: " + minWindow(s, t));

		  System.out.println("checkInclusion: " + checkInclusion(t, s));
	  }

	public static boolean checkInclusion(String s1, String s2) {
		if (s1.length() > s2.length())
			return false;
		HashMap < Character, Integer > s1map = new HashMap<> ();

		for (int i = 0; i < s1.length(); i++)
			s1map.put(s1.charAt(i), s1map.getOrDefault(s1.charAt(i), 0) + 1);

		for (int i = 0; i <= s2.length() - s1.length(); i++) {
			HashMap <Character, Integer> s2map = new HashMap<> ();
			for (int j = 0; j < s1.length(); j++) {
				s2map.put(s2.charAt(i + j), s2map.getOrDefault(s2.charAt(i + j), 0) + 1);
			}
			if (matches(s1map, s2map))
				return true;
		}
		return false;
	}

	public static boolean matches(HashMap <Character, Integer> s1map, HashMap <Character, Integer> s2map) {
		for (char key: s1map.keySet()) {
			if (s1map.get(key) - s2map.getOrDefault(key, -1) != 0)
				return false;
		}
		return true;
	}
	}

class MyCharMap {
	int i;
	char ch;
	public MyCharMap(int idx, char c) {
		this.i = idx;
		this.ch = c;
	}
}