package Sort;

import java.util.*;
//求排序后最大的相邻两数差值
public class Gap {
    public int maxGap(int[] A, int n) {
        if (n <= 1){
            return 0;
        }if (n == 2){
            return Math.abs(A[1] - A[0]);
        }
        //题目是排序后的求差值最大
        Arrays.sort(A);
        int max = 0;
        for (int i = 1; i < n; i++){
            if (Math.abs(A[i] - A[i-1]) > max){
                max = Math.abs(A[i] - A[i-1]);
            }
        }
        return max;
    }
}