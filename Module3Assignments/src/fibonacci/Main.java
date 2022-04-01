package fibonacci;

public class Main {
    public static void main(String[] args) {
        final int FIB_PAIR = 1;
        final int FIB_SUM_INIT = 1;


        System.out.print(fibonacci(FIB_PAIR,FIB_PAIR,2,FIB_SUM_INIT));

    }


    public static int fibonacci(int a, int b, int limit, int sum){
        if(limit > 1) return (fibonacci(b, a+b, limit-1, sum+b));
        else return (sum);
    }
}
