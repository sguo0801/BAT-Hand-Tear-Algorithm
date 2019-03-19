package Sort;

import java.util.*;
//归并排序
public class MergeSort {
//    public int[] mergeSort(int[] A, int n) {
//        //准备一个各个子序列相同元素个数的数组
//        int[] temp = new int[n];
//        sort(A, 0, n-1, temp);
//        return A;
//    }
//
//    //开始划分子序列,分成各个区域,本身包含了合并排序的merge方法.
//    public  static void sort(int[] A, int left, int right, int[] temp){
//        //如果left>=right,则说明只有一个数啦,就不需要划分啦.目的是分成最小的只包含两个数的子序列
//        if (left < right) {
//            int mid = (left + right) / 2;
//            sort(A, left, mid, temp);
//            sort(A, mid + 1, right, temp);
//            //分而合之,就行排序重新组合
//            merge(A, left, mid, right, temp);
//        }
//    }
//
//    //开始写合并的算法
//    public static void merge(int[] A, int left, int mid, int right, int[] temp){
//        //left,mid,right都保持固定值进行排序位置坐标,需要两个指针来对左右两个数组进行排序.
//        int i = left;  //左数组指针的初始位置
//        int j = mid +1;  //右数组指针的初始位置
//        int t = 0;  //放到temp中的临时指针
//
//        //两边子序列都有值的情况
//        while (i <= mid && j <= right) {
//            if (A[i] <= A[j]) {      //谁小谁先放进临时数组,且相同的时候先把左边放进去再说
//                temp[t++] = A[i++];
//            } else {
//                temp[t++] = A[j++];
//            }
//        }
//        while (i <= mid){
//            temp[t++] = A[i++];
//        }
//        while (j <= right){
//            temp[t++] = A[j++];
//        }
//
//        //开始复制回原始数组,用最小值left开始从左往右复制.
//        t = 0;    //掰回指针
//        while ( left <= right){    //????为什么条件用  t<temp.length 就不行?  temp不是当前的?
//            A[left++] = temp[t++];
//        }
//    }

    public static int[] mergeSort(int[] A, int low, int high) {
        if (low < high) {  //是if,不是while.表示判断截止,不是循环.
            int mid = low + (high - low) / 2;
            mergeSort(A, low, mid);
            mergeSort(A, mid + 1, high);
            merge(A, low, mid, high);
        }
        return A;
    }

    public static void merge(int[] A, int low, int mid, int high){
        int[] temp = new int[high-low+1];  //构建一个新数组.最后用于覆盖
        int k = 0;  //作为临时数组的索引
        int i = low;
        int j = mid+1;
        while (i <= mid && j <= high){  //放小的值,直到有一边数组都已经放空.
            if (A[i] < A[j]){
                temp[k++] = A[i++];
            }else {
                temp[k++] = A[j++];
            }
        }

        while (i <= mid){
            temp[k++] = A[i++];
        }

        while (j <= high){
            temp[k++] = A[j++];
        }

        //覆盖
        for (int m = 0; m < temp.length; ++m){
            A[m+low] = temp[m];
        }
    }

    public static void main(String[] args){
        int[] a = { 2, 7, 8, 3, 1, 6, 9, 0, 5, 4 };
        mergeSort(a, 0, a.length - 1);
        for (int i = 0; i < a.length; i++){
            System.out.println(a[i]);
        }
    }

}
