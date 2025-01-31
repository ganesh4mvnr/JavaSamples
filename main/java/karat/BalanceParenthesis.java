package karat;

import java.util.HashMap;
import java.util.Stack;

public class BalanceParenthesis {
    public static void main(String[] args) {
        HashMap<Character, Character> paranMap = new HashMap<>();
        paranMap.put('}', '{');
        paranMap.put(']', '[');
        paranMap.put(')', '(');

        String input = "{}([(||)])";

        Stack<Character> characterStack = new Stack<>();
        char[] inpArr = input.toCharArray();
        int len = inpArr.length;

        if (len > 0)
            for (Character c: inpArr) {
                if (characterStack.isEmpty())
                    characterStack.push(c);
                else {
                    Character mappedChar = paranMap.get(c);
                    if (characterStack.peek() == mappedChar) {
                        characterStack.pop();
                    } else
                        characterStack.push(c);
                }
            }
        if (characterStack.isEmpty() || len == 0) {
            System.out.println("Balanced parenthesis");
        } else
            System.out.println("NOT Balanced parenthesis");
    }
}
