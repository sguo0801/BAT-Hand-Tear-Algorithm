package BinSearch;
import java.util.*;
//有序循环数组最小值
public class MinValue {
    public int getMin(int[] arr, int n) {
        if (arr == null || n == 0){
            return -1;
        }
        //这边是数组中只有一个元素,或者第一个元素小于最后一个元素,说明是升序排列的,否则只要最小值循环到后段,都是第一个元素大于最后一个元素
        if (n == 1 || arr[0] < arr[n-1]){
            return arr[0];
        }
        int left = 0;
        int right = n-1;
        //目的是找到最小值所在的那段循环.
        while (left < right){
            int mid = left + (right - left)/2;
            //mid要大于右,小于左.这两个条件.这个时候是有循环的.
            if (arr[mid] > arr[right]){
                left = mid + 1;  //mid这个大值点直接筛掉.
            }else if (arr[mid] < arr[left]){
                right = mid;   //要留住mid这个小值点.
            }else {
                //此时说明已经是从left到right升序啦
                break;
            }
        }
        if (left == right){ //刚好截到了最小值
            return arr[left];
        }
        int min = arr[left];
        //开始遍历剩下的小循环.
        while (left <= right){
            if (arr[left] < min){
                min = arr[left];
            }
            left++;
        }
        return min;
    }
}