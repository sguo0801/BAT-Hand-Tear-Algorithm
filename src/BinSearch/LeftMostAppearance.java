package BinSearch;
import java.util.*;
//元素最左出现练习
public class LeftMostAppearance {
    public int findPos(int[] arr, int n, int num) {
        if (arr == null || arr.length == 0){
            return -1;
        }
        int left = 0;
        int right = n - 1;
        int res = -1;
        while (left <= right){
            int mid = left + (right-left)/2;
            if (arr[mid] > num){
                right = mid - 1;
            }else if (arr[mid] < num){
                left = mid + 1;
            }else {
                res = mid;
                right = mid - 1;
            }
        }
        return res;
    }
}