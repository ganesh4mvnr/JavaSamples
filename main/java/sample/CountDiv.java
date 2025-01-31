package sample;

public class CountDiv {
    private static int countDiv(int A, int B, int K) {
        return A==B  ? A%K==0 ? 1:0 : 1+((B-A)/K)*K /K;
    }

    public static void main(String[] args) {
        {
            int a=10;  int b=10; int k=5; int result=1;
            System.out.println( a + "..." + b + "/" + k + " = " +  countDiv(a,b,k)  + (result!=countDiv(a,b,k) ? " WRONG" :" (OK)" ));
        }

        {
            int a=10;  int b=10; int k=7; int result=0;
            System.out.println( a + "..." + b + "/" + k + " = " +  countDiv(a,b,k)  + (result!=countDiv(a,b,k) ? " WRONG" :" (OK)" ));
        }

        {
            int a=6;  int b=11; int k=2; int result=3;
            System.out.println( a + "..." + b + "/" + k + " = " +  countDiv(a,b,k)  + (result!=countDiv(a,b,k) ? " WRONG" :" (OK)" ));
        }

        {
            int a=6;  int b=2000000000; int k=3; int result=b-a+1;
            System.out.println( a + "..." + b + "/" + k + " = " +  countDiv(a,b,k)  + (result!=countDiv(a,b,k) ? " WRONG" :" (OK)" ));
        }
    }
}
