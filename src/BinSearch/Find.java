package BinSearch;
import java.util.*;
//有序递增序列找最左原位(arr[i]=i.
public class Find {
    public int findPos(int[] arr, int n) {
        if (arr == null || n == 0){
            return -1;
        }
        int left = 0;
        int right = n-1;
        int res = -1;
        while (left <= right){
            if (arr[left] > left || arr[right] < right){
                break;
            }
            int mid = left + (right - left)/2;
            if (arr[mid] < mid){
                left = mid + 1;
            }else if (arr[mid] > mid){
                right = mid - 1;
            }else {
                res = mid;
                right = mid - 1;
            }
        }
        return res;
    }
}