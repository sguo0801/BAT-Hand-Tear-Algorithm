package Sort;

import java.util.*;

public class QuickSort {
    public static int[] quickSort(int[] A, int n) {  //自己写实例的话,要用static
//        //直接引用方法,把A导进去
//        quick(A, 0, n - 1);
//        return A;
//    }
//
//    //开始进行快速排序,l是最左边的值,r为最右边的值
//    public static void quick(int[] A, int l, int r) {
//        //递归分治法
//        if (l < r) {
//            //找到左右两个索引,i从左向右,j从右向左.其中l,r为固定值,当做子序列的边界
//            int i = l;
//            int j = r;
//            int x = A[l];
//            //每一趟都是最后是的 i=j 时结束.
//            while (i < j) {
//                //第一个位置挖了一个坑,然后从后往前开始找比x小的,放进坑里
//                while (i < j && A[j] > x)
//                    j--;
//
//                //好啦,找到那个x小的值啦
//                if (i < j) {
//                    A[i++] = A[j];
//                }
//
//
//                //开始从前往后找比X大的值
//                while (i < j && A[i] < x)
//                    i++;
//
//                //好啦,从前到后找到了那个比x大的值,放进A[j]这个坑里
//                if (i < j) {
//                    A[j--] = A[i];
//                }
//
//            }
//            //此时,i=j,把x填进坑里
//            A[i] = x;
//            quick(A, l, i - 1);
//            quick(A, i + 1, r);
//        }
//    }
        quick(A, 0, n - 1);
        return A;
    }
    public static void quick(int[] A, int low, int high) {
        if (low < high) {  //!!!递归要有截止条件
            int i = low;
            int j = high;
            int x = A[i];  //找到那个基准值.此处为第一个.如果是别的值,可以将那个值跟第一个交换即可.
            while (i < j) {
                while (i < j && A[j] > x) {
                    j--;
                }

                if (i < j) {  //从后往前找到了那个比基准值小的值.
                    A[i++] = A[j];   //填了第一个坑,就是第一个索引处.
                }

                while (i < j && A[i] < x) {
                    i++;
                }

                if (i < j) {
                    A[j--] = A[i];
                }
            }
            A[i] = x; //遍历完成,此时可以将最初的基准值填入.
            quick(A, low, i - 1);
            quick(A, i + 1, high);

        }
    }

    public static void main(String[] args){
        int[] a = {13,33,22,1,23,14,12};
        quickSort(a, a.length);
        for (int i = 0; i < a.length; i++){
            System.out.println(a[i]);
        }
    }

}
//参考:https://blog.csdn.net/morewindows/article/details/6684558