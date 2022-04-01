package fibonacci;

public class Main {
    public static void main(String[] args) {
        //the first two numbers of the fibonacci sequence is 1 and 1
        final int FIB_PAIR = 1;

        //the sum starts at 1 and grows as N increases
        final int FIB_SUM_INIT = 1;

        //set limit (third param) to N                 DOWN HERE
        System.out.print(fibonacci(FIB_PAIR,FIB_PAIR, 10,FIB_SUM_INIT));

    }

//does this count as 2 lines? LOL
    public static int fibonacci(int a, int b, int limit, int sum){
        if(limit > 1) return (fibonacci(b, a+b, limit-1, sum+b));
        else return (sum);
    }
}
