package Sort;

import java.util.*;
//荷兰国旗问题
public class ThreeColor {
    public int[] sortThreeColor(int[] A, int n) {
        if (A == null || n < 2 ){
            return A;
        }
        int left = -1;
        int index = 0;
        int right = n;
        while (index < right){
            //集中情况中选,用if.. else if..
            if (A[index] == 0){
                swap(A, index++, ++left);
            }else if (A[index] == 1){
                index++;
            }else {
                swap(A, index, --right);
            }
        }
        return A;
    }

    public void swap(int[] A, int a, int b){
        int temp = A[a];
        A[a] = A[b];
        A[b] = temp;
    }
}