package main;
import static java.lang.System.out;
public class fibonacci {

    public static void main(String[] args){
        int n=5;
        func(100);
    }

    //returns the nth fibonacci number
    static int  fibo (int n){
        if (n <= 1)
            return n;
        return fibo(n-1)+fibo(n-2);
    }

    //divide by 2 
    static void func (float x){
        if (x<=1.0)
            return ;
        
        out.print(x +" ");
        func(x/2.0f);
        
    }
}

