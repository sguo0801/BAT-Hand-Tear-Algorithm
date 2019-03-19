package DP;
import java.util.*;
//矩阵最小路径和
public class MinimumPath {
    public int getMin(int[][] map, int n, int m) {
        //先建立一个相同大小的dp矩阵.
        int[][] dp = new int[n][m];
        dp[0][0] = map[0][0];  //第一个格肯定是map中第一个数,因为左上角没有值.
        //先把第一行,第一列确定好.因为第一个数确定好了,所以i,j从1开始.m,n要区分好!!
        for (int i = 1; i < m; i++){  //第一行
            dp[0][i] = dp[0][i-1] + map[0][i];
        }
        for (int j = 1; j < n; j++){  //第一列
            dp[j][0] = dp[j-1][0] + map[j][0];
        }
        for (int i = 1; i < n; i++){
            for (int j = 1; j < m; j++){
                dp[i][j] = Math.min(dp[i-1][j]+map[i][j], dp[i][j-1]+map[i][j]);
            }
        }
        return dp[n-1][m-1];
    }
}