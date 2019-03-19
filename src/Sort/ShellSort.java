package Sort;
import java.util.*;

public class ShellSort {
    public int[] shellSort(int[] A, int n) {
        int i, j, gap;
        for (gap = n/2; gap > 0; gap /= 2 ){
            for (i = 0; i < gap; i++){
                for (j = i + gap; j < n; j += gap){
                    if (A[j] < A[j - gap]){
                        int temp = A[j];
                       // int k = j - gap;
                        //注意越界问题,j-gqp要管好.
                        while (j - gap >= 0 && A[j - gap] > temp) {
                            A[j] = A[j - gap];
                            j -= gap;
                        }
                        A[j] = temp;
                    }
                }
            }
        }
        return A;
    }
}
//https://www.nowcoder.com/study/vod/1/2/8  希尔排序有些懵,还有两种优化,后面要再看