package DP;
import java.util.*;
//最长递增子序列长度
public class LongestIncreasingSubsequence {
    public int getLIS(int[] A, int n) {
        int[] dp = new int[n];
        dp[0] = 1;  //第一个数自己就是一个序列
        int max = 0;
        for (int i = 1; i < n; i++){
            int maxans = 0;
            for (int j = 0; j < i; j++){
                   if (A[i] > A[j]){
                       maxans = Math.max(dp[j], maxans);
                   }
            }
            dp[i] = maxans + 1;
            max = Math.max(dp[i], max);
        }
        return max;
    }
}