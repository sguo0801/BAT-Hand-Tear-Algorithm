package Sort;

import java.util.*;
//有序数组合并
public class Merge {
    public int[] mergeAB(int[] A, int[] B, int n, int m) {
        while (m != 0){
            if (n == 0){
                //此时只有m个数,且每把B中元素放进A中,就要索引-1.注意别马虎.
                A[m -1] = B[m -1];
                m--;
                //从后往前排.谁大,谁在后面.且每扔掉一个则原数组索引-1,再进行比较.
            }else {
                A[m+n-1] = A[n-1] > B[m -1] ? A[--n] : B[--m];
            }
        }
        return A;
    }
}