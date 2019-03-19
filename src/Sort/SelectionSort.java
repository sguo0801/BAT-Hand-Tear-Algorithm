package Sort;
//不用for的效率更高
//import java.util.*;
////
//public class SelectionSort {
//    public int[] selectionSort(int[] A, int n) {
//        int temp = 0;
//        for(int i = 0; i<n; i++){
//            int min = A[i];  //取每次剩余第一个元素为初始min
//            int j=i;
//            int k =0;
//            while(j<n){
//                if(min < A[j]){
//                    j++;
//                }else{
//                    min=A[j];
//                    k=j;          //标注每次最小值所在的index
//                    j++;
//                }
//            }
//            temp = A[i];            //注意j发生了变化,所以要用i
//            A[i] = A[k];
//            A[k] = temp;
//        }
//        return A;
//    }
public class SelectionSort{
    public static int[] selectionSort(int[] A){
        for (int i = 0; i < A.length; ++i){
            int min = A[i];
            int k = i;  //k作为最小值下标每次都是用i初始化.
            for (int j = i; j < A.length; j++){ //j到最后一个元素结束
                if (min < A[j]){}
                else {
                    min = A[j];
                    k = j;
                }
            }
            swap(A, i, k);
        }
        return A;
    }
    public static void swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
    public static void main(String[] args){
        int[] A = {1,3,23,22,12,32,11};
        selectionSort(A);
        for (int i = 0; i < A.length; i++){
            System.out.println(A[i]);
        }
    }

}
