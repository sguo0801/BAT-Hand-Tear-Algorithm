package Sort;
import java.util.*;
//计数排序
public class CountingSort {
    public int[] countingSort(int[] A, int n) {
        if (A == null || n < 2){
            return A;
        }
        //找最大最小值
        int min = A[0];
        int max = A[0];

        for (int i =0; i < n; i++){
            min = Math.min(min, A[i]);
            max = Math.max(max, A[i]);
        }
        //创建桶数组,要有偏移量.往里面装数字,则用的是原数组的长度.
        int[] countArr = new int[max - min + 1];
        for (int i = 0; i < n; i++){
         //   while (A[i] - min >= 0){      //没必要的循环不能有,超出运行时间,
                countArr[A[i]-min]++;
           // }
        }
        int index = 0;
        //取出数的时候,用的是新数组的长度.
        for (int i = 0; i < countArr.length; i++){

            while (countArr[i]-- > 0)
            A[index++] = i + min;
        }
        return A;
    }
}
//参考:https://www.sohu.com/a/258882297_478315