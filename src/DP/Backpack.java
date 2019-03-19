package DP;
import java.util.*;
//背包练习题
public class Backpack {
    public int maxValue(int[] w, int[] v, int n, int cap) {
        int[] dp = new int[cap+1];
        for (int j = 0; j < n; j++){
            for (int i = cap; i >= w[j]; i--){
                    dp[i] = Math.max(dp[i], dp[i-w[j]]+v[j]);
            }
        }
        return dp[cap];
    }
}