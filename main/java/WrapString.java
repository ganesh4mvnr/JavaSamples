/*We are building a word processor and we would like to implement a "word-wrap" functionality.

Given a list of words followed by a maximum number of characters in a line, return a collection of strings where each string element represents a line that contains as many words as possible, with the words in each line being concatenated with a single '-' (representing a space, but easier to see for testing). The length of each string must not exceed the maximum character length per line.

Your function should take in the maximum characters per line and return a data structure representing all lines in the indicated max length.

Examples:

words1 = [ "The", "day", "began", "as", "still", "as", "the",
          "night", "abruptly", "lighted", "with", "brilliant",
          "flame" ]

wrapLines(words1, 13) "wrap words1 to line length 13" =>

  [ "The-day-began",
    "as-still-as",
    "the-night",
    "abruptly",
    "lighted-with",
    "brilliant",
    "flame" ]

wrapLines(words1, 20) "wrap words1 to line length 20" =>

  [ "The-day-began-as",
    "still-as-the-night",
    "abruptly-lighted",
    "with-brilliant-flame" ]
    
words2 = [ "Hello" ]

wrapLines(words2, 5) "wrap words2 to line length 5" =>

  [ "Hello" ]

words3 = [ "Hello", "world" ]

wrapLines(words3, 5) "wrap words3 to line length 5" =>

  [ "Hello", 
  "world" ]

words4 = ["Well", "Hello", "world" ]

wrapLines(words4, 5) "wrap words4 to line length 5" =>

  [ "Well",
  "Hello", 
  "world" ]

words5 = ["Hello", "HelloWorld", "Hello", "Hello"]

wrapLines(words5, 20) "wrap words 5 to line length 20 =>

  [ "Hello-HelloWorld",
    "Hello-Hello" ]


n = number of words OR total characters

*/

import java.io.*;
import java.util.*;

public class WrapString {
    public static void main(String[] argv) {
        String[] words1 = {"The", "day", "began", "as", "still", "as", "the", "night", "abruptly", "lighted", "with", "brilliant", "flame"};
        int lineLength1_1 = 13;
        int lineLength1_2 = 20;

        String[] words2 = {"Hello"};
        int lineLength2_1 = 5;

        String[] words3 = {"Hello", "world"};
        int lineLength3_1 = 5;

        String[] words4 = {"Well", "Hello", "world"};
        int lineLength4_1 = 5;

        String[] words5 = {"Hello", "HelloWorld", "Hello", "Hello"};
        int lineLength5_1 = 20;

        System.out.println(myWrapString(words1, 13));
    }

    public static String wrapString(String[] words, int length) {
        String result = "";
        int nextIndex = 0;

        for (int i = 0; i < words.length; i++) {
            String nextStr = "";
            if (words[i].length() <= length) {
                result += words[nextIndex];
                StringBuilder sb = new StringBuilder(words[nextIndex]);
                for (int j = 0; sb.toString().length() <= length; j++) {
                    if (i < words.length - 1) {
                        nextStr = words[i + 1];
                    }
                    if (nextStr != null && nextStr.length() > 0) {
                        sb.append("-");
                        sb.append(nextStr);
                    }
                    if (sb.toString().length() > length) break;
                }
                if (sb.toString().length() <= length) {
                    result += sb.toString();
                } else {
                    result += "\n";
                }
                nextIndex++;
                System.out.println("nextIndex: " + nextIndex);
                //System.out.println("result in iteration" + i + ": " + result);
            } else {

                result += "\n";
            }
        }

        System.out.println("result =" + result);


        return result;
    }

    public static String myWrapString(String[] words, int maxLen) {
        int wordArrLen = words.length;
        String result = "";
        int wordLen = 0;
        StringBuilder builder = new StringBuilder();

        for (String word : words) {
            wordLen += word.length();
            if (wordLen <= maxLen) {
                builder.append(word);
                if (wordLen != maxLen) {
                    builder.append("-");
                    wordLen++;
                }
            } else {
                String prevWord = builder.toString();
                if (prevWord.endsWith("-")) {
                    int idx = prevWord.lastIndexOf('-');
                    builder.delete(idx, idx+1);
                }
                builder.append("\n");
                wordLen = word.length();
                builder.append(word);
                if (wordLen != maxLen) {
                    builder.append("-");
                    wordLen++;
                }
            }
        }


        return builder.toString();
    }
}
