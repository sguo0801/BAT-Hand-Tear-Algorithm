package Sort;

import java.util.*;
//最短子数组练习
//从左边起，不断更新最大值，找到A【i】值比最大值大时替换最大值，比最大值小时更新下标记录为l。等于情况跳过,不能管,因为等于是正序的
//从右边起，不断更新最小值，找到A【i】值比最小值小时替换最小值，比最小值大时更新下标记录为r。
public class Subsequence {
    public int shortestSubsequence(int[] A, int n) {
        int max = A[0];
        int min = A[n-1];
        int l = 0;
        int r = 0;
        for (int i = 0; i < n; i++){
            //等于是不需要管的,因为不需要换,当做没看到.
            if (A[i] > max){
                max = A[i];
                //有重复的时候不管,但是不包含进去.
            }else if(A[i] < max){
                l = i;
            }
        }
        for (int i = n-1; i >= 0; i--){
            if (A[i] < min){
                min = A[i];
                //因为等于当做没看到,所以不包括在取l,r中.
            }else if(A[i] > min){
                r = i;
            }
        }
        //说明最初就是顺序的,所以要==0,否则弹出错误的1.
        if (l == r){
            return 0;
        }else {
            return l - r +1;
        }
    }
}