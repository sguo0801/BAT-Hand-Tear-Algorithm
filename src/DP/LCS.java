package DP;
import java.util.*;
//LCS题型
public class LCS {
    public int findLCS(String A, int n, String B, int m) {
        if (A == null || B == null || n < 1 || m < 1){
            return 0;
        }
        char[] a = A.toCharArray(),b = B.toCharArray();
        // dp[i][j]：A[:i+1]和B[:j+1]所包含的LCS长度
        // dp[0][0] 表示两个都是空字符串
        int[][] dp = new int[n+1][m+1];
        for (int i = 1; i <= n; ++i){
            for (int j = 1; j <= m; ++j){
                // 这里的i-1和j-1实际上是下标左移，以回归从0开始。
                // 1. 当前字符相等，LCS一定在之前最长的基础上+1
                // 2. 当前字符不相等，则要考虑到达当前位置的路径：
                //    a. A的子串加1字符，B的子串不变；
                //    b. A的子串不变，B的子串加1字符。
                //    则不相等时，LCS长度取上两种路径中最大的。
                if (a[i-1] == b[j-1]){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[n][m];
    }
}