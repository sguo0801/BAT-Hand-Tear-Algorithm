package Sort;


//public class InsertionSort {
//    public int[] insertionSort(int[] A, int n) {
//        for (int i = 1; i<n; i++){   //i只控制趟数:n-1趟
//            //从第二个数开始,A[j]当做对比的固定值并且赋给temp
//            int j = i;
//            int temp = A[j];
//            //只要比前一个数小,则就有一个数向后挪一个索引,最后才能在恰当的位置留一个空.
//            while (j >0 && temp < A[j-1]){
//                A[j] = A[j-1];
//                //temp从后向前继续对比
//                j--;
//            }
//            //把temp插入.
//            A[j] = temp;
//        }
//        return A;
//    }
//
//}
public class InsertionSort{
    public static int[] insertionSort(int[] A){
        for (int i = 1; i < A.length; i++){
            int j = i;
            int temp = A[j];
            while (j > 0 && temp < A[j-1]){  //要注意是temp来比
                A[j] = A[j - 1];
                j--;
            }
            A[j] = temp;
        }
        return A;

    }


    public static void main(String[] args){
        int[] arr = {12,21,2,33,44};
        insertionSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}