package Sort;
//public class BubbleSort {
//    public int[] bubbleSort(int[] A, int n) {
//        int temp = 0;
//        if (A == null || n < 2){
//            return A;
//        }
//        for(int i = 0; i < n-1; i++){         //比较几趟
//            for(int j = 0; j < n - i - 1; j++){            //每趟比较几次
//                if(A[j] > A[j+1]){
//                    temp = A[j];
//                    A[j] = A[j+1];
//                    A[j+1] = temp;
//                }
//            }
//        }
//        return A;
//    }
//}
public class BubbleSort{
    public static int[] sort(int[] a){  //这边要用static,才可以调用方法.
        for (int i = 0; i < a.length - 1; ++i){
            for (int j = 0; j < a.length - i - 1; ++j){
                if(a[j] > a[j+1]) {
                    swap(a, j, j + 1);
                }
            }
        }
        return a;
    }

    public static void swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }


    public static void main(String[] args){
        int[] a = {1,2,3,5,2,3};
        sort(a);
        for (int i = 0; i < a.length; i++){
            System.out.println(a[i]);
        }

    }
}

