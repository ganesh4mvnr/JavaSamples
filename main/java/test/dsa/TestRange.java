package test.dsa;

// A Java program for merging overlapping intervals
import java.util.Arrays;
        import java.util.Comparator;
        import java.util.Stack;
public class TestRange {

    public static void combineRanges(Range arr[])
    {
        if (arr.length <= 0)
            return;

        Stack<Range> stack=new Stack<>();

        Arrays.sort(arr,new Comparator<Range>(){
            public int compare(Range i1, Range i2)
            {
                return i1.start-i2.start;
            }
        });

        // push the first interval to stack
        stack.push(arr[0]);

        // Start from the next interval and merge if necessary
        for (int i = 1 ; i < arr.length; i++)
        {
            // get interval from stack top
            Range top = stack.peek();

            // if current interval is not overlapping with stack top,
            // push it to the stack
            if (top.end < arr[i].start)
                stack.push(arr[i]);

                // Otherwise update the ending time of top if ending of current
                // interval is more
            else if (top.end < arr[i].end)
            {
                top.end = arr[i].end;
                stack.pop();
                stack.push(top);
            }
        }

        // Print contents of stack
        System.out.print("The Merged Intervals are: ");
        while (!stack.isEmpty())
        {
            Range t = stack.pop();
            System.out.print("["+t.start+","+t.end+"] ");
        }
    }
}

class Range
{
    int start,end;
    Range(int start, int end)
    {
        this.start=start;
        this.end=end;
    }
}
// This code is contributed by Gaurav Tiwari
