package DP;
import java.util.*;
//上台阶问题.
public class GoUpstairs {
    public int countWays(int n) {
        if (n < 0){
            return 0;
        }
        if (n == 1 || n == 2){
            return n;
        }else {
            //从下到上累加方法数,直接递归会溢出数组越界.
            int first = 1;
            int second = 2;
            int fib = 0;
            for (int i = 3; i <= n; i++) {
                fib = (first + second)%1000000007; //防止数组越界.
                first = second;
                second = fib;
            }
            return fib;
        }
    }
}