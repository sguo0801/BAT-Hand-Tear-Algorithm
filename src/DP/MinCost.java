package DP;
import java.util.*;

public class MinCost {
    public int findMinCost(String A, int n, String B, int m, int c0, int c1, int c2) {
        if(n < 0 || m < 0)
            return -1;
        int[][] dp = new int[n+1][m+1];//A，B初始包含空"",故长度为n+1
        char[] charA = A.toCharArray();
        char[] charB = B.toCharArray();
        //初始化第一行，将A空("")编辑为对应B[0-j],直接插入
        for(int j = 0; j < m+1; j++) {
            dp[0][j] = c0 * j;
        }

        //初始化第一例，将A[0-i]编辑为对应B空(""),直接删除
        for(int i = 0; i < n+1; i++) {
            dp[i][0] = c1 * i;
        }

        /*
         * 初始化内部dp，dp[i][j]分以下几种情况
         * 总尝试去找dp[i][j] 和 dp[i-1][j], dp[i][j-1], dp[i-1][j-1]之间的关系
         * 1 dp[i][j] = dp[i-1][j] + delete[i]
         * 2 dp[i][j] = dp[i][j-1] + insert[j]
         * 3 dp[i][j] = dp[i-1][j-1] + replace[i]->[j] (charA[i] != charB[j])
         *   第三种情况，将i变成j可直接替换，也可先删除再插入，具体看哪种代价小，即c2和c0+c1比较
         * 4 dp[i][j] = dp[i-1][j-1] (charA[i] = charB[j])
         */
        for(int i = 1; i < n+1; i++) {
            for(int j = 1; j < m+1; j++) {
                dp[i][j] = 0;
                dp[i][j] = Math.min(dp[i-1][j]+c1, dp[i][j-1]+c0);
                if(charA[i-1] == charB[j-1]) {
                    dp[i][j] = Math.min(dp[i][j], dp[i-1][j-1]);
                }else {
                    if(c2 <= c0+c1)
                        dp[i][j] = Math.min(dp[i][j], dp[i-1][j-1]+c2);
                    else
                        dp[i][j] = Math.min(dp[i][j], dp[i-1][j-1]+c0+c1);
                }
            }
        }
        return dp[n][m];
    }
}