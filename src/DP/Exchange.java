package DP;
import java.util.*;
//用一个硬币数组,组成aim的面值有多少种方法
public class Exchange {
    int res;
    public int countWays(int[] penny, int n, int aim) {
        if (aim <= 0){  //目标为0元
            return 0;
        }
        if (n == 0){
            return 0;  //相当于没有硬币
        }
        int money = penny[0];
        return coinsLope(penny, 0, aim);  //penny中从索引到n-1的面值情况中组成aim有多少种方法.
    }
    //暴力搜索,一个索引值代表一种面值,把一种面值的所有情况(从0张到满足aim的最大张)列举出来,剩余的钱再把剩下的面值表示出来
    //方法总数是递归累加而来的,所以会有重复
    public int coinsLope(int[] penny, int index, int aim){
        if (index >= penny.length){
            return 0;
        }
        if (index == penny.length - 1){
            res = aim%penny[index] == 0 ? 1 : 0;  //就是最后一种面值是否能把目标面值给凑到,即目标金额是最后一种面值的整数倍,有则多一种方法
            return res;
        }
        for (int i = 0; penny[index] * i <= aim; i++){
            res += countWays(penny, index+1, aim-penny[index]*i);  //递归相加,第一种面值确定,则看第二种面值从开始到结束的所有方法.依次继续.
        }
        return res;
    }
    //记忆化搜索,防止重复计算,每计算完一个结果,都将结果放在一个map表中,index和aim共同组成key,返回结果为value.
    public int coinsMap(int[] penny, int index, int aim){
        int[][] map = new int[index+1][aim+1];  //
        Arrays.fill(map, -1);  //先把每一个map索引对应的值置为-1;
        if (index >= penny.length){
            return 0;
        }
        if (index == penny.length - 1) {
            res = aim % penny[index] == 0 ? 1 : 0;  //就是最后一种面值是否能把目标面值给凑到,即目标金额是最后一种面值的整数倍,有则多一种方法
            return res;
        }
        for (int i = 0; penny[index]*i <= aim; i++){
            int temp = 0;
            if (map[index][aim] == -1){  //说明还没有出现过.
                temp = coinsLope(penny, index+1, aim-penny[index]*i);
                map[index][aim] = temp;  //既然没有出现过,则就要继续递归并且更新temp
            }else {
                temp = map[index][aim];  //出现过则不用递归去重复搜索
            }
            res += temp;
        }
        return res;
    }
    //动态规划
    public int coinsDP(int[] penny, int n, int aim){
        int[][] map = new int[n][aim+1];  //n为行数.
        Arrays.fill(map, -1);
        //填充第一列
        for (int i = 0; i < n; i++){  //从上到下
            map[i][0] = 1;
        }
        //填充第一行
        for (int i = 0; i < aim + 1; i++){  //从左到右
            if (i%penny[0] == 0){
                map[0][i] = 1;
            }else {
                map[0][i] = 0;
            }
        }
        //根据第一行和第一列的结果可以推断出第二行和第二列的结果,但是当j很小时,可能一张penny[i]都装不下,则直接等于0到i-1情况的总数.
        //其实就是一个点的方法数为其左上部分的方法和，同行则为使用penny[i]的情况,在点右侧均不考虑,因为aim还没有到那么高,只到j的情况.
        //虽然最后肯定是到aim,但是那是右下角的点计算得来的,同样需要前面的方法和.
        //枚举方法时间复杂度依然为on*aim2,只有改进化简后dp[i][j]=dp[i][j-arr[i]]+dp[i-1][j],此时为on*aim的时间复杂度.
        for (int i = 1; i < n; i++){
            for (int j = 1; j < aim; j++) {
                if (j - penny[i] >= 0) {
                    map[i][j] = map[i][j - penny[i]] + map[i - 1][j];
                } else {
                    map[i][j] = map[i - 1][j];
                }
            }
        }
        return map[n-1][aim];
    }
}