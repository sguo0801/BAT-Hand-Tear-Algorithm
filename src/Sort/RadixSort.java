package Sort;

import java.util.*;
//基数排序
public class RadixSort {
    public int[] radixSort(int[] A, int n) {
        //小于2000,四个位,排序四次.
        for (int w = 1; w <= 4; w++) {
            int[] aux = new int[n];
            int[] count = new int[11];
            //频率估计
            for (int i = 0; i < n; i++) {
                int temp = getBit(A[i], w);
                count[temp + 1]++;
            }

            //将频率转化成索引
            for (int i = 0; i < 10; i++) {
                count[i + 1] = count[i + 1] + count[i];
            }
            //数据分类
            for (int i = 0; i < n; i++){
                int temp = getBit(A[i], w);
                aux[count[temp]++] = A[i];
            }
            //回写
            for (int i = 0;i < n; i++){
                A[i] = aux[i];
            }
        }
        return A;
    }

    public static int getBit(int n, int k){
        while (k > 1){
            n = n / 10;
            k--;
        }
        return n % 10;
    }
}
//完全没想法!!