package Sort;
import java.util.*;

public class HeapSort {
    public static int[] heapSort(int[] A, int n) {
//        int i;
//        //构建大顶堆(升序),从最后一个非叶子节点(数组长度一半/2)开始,从后往前调整.
//        for (i = n/2 - 1; i >= 0; i--){
//            //开始进行调整,大值往上来
//            adjustHeap(A, i, n);
//        }
//        //已经是大顶堆啦,然后将根节点与最后一个节点交换,将根节点调整后已经为最大,这时交换放在最后,作为有序部分.
//        for (int j = n - 1; j > 0; j--){
//            swap(A, 0, j);
//            //交换一个值后,再重新调整,此时是去掉最大值的其他元素构成大顶堆,只不过从0开始,相当于把小值一层层往下传,换第二大值上来,之后再交换.
//            adjustHeap(A, 0, j);
//        }
//        return A;
//    }
//
//    //调整的方法主要是把大值往上送.是指的单个小子二叉树之间找最大值(确定k),调用前的for循环可以往上面一层层的送
//    public static void adjustHeap(int[] A, int i, int n){
//        //先把值取出来,等着进行交换
//        int temp = A[i];
//        //从指定非叶子节点的左子节点开始找,再找孙子节点,这里是往下一层层找,先从1.2层换,再2.3层换,只有第一次是从最下面非叶子节点开始,
//        for (int k = 2 * i + 1; k < n; k = 2 * k + 1){   //第一次换好了最上层,然后下面第二层再继续调整,直到变成完美的大顶堆
//            //左右两个叶子节点进行比较,让k指向大的那个,这里是两个叶子节点之间选,
//            if (k + 1 < n && A[k] < A[k+1]){
//                k++;   //就是左子节点小,则指向右子节点,相当于确定了k
//            }
//            //在该终端二叉树中找到那个大值,放到这个终端二叉树的根节点上,同时它也是上层数的子节点.
//            if (A[k] > temp){
//                A[i] = A[k];
//                i = k;
//            }else {
//                break;
//            }
//        }
//        A[i] = temp;   //把原来的非叶子节点的值传下来了.
//    }
//
//    public static void swap(int[] A, int a, int b){
//        int temp = A[a];
//        A[a] = A[b];
//        A[b] = temp;
//    }
        for (int i = n / 2 - 1; i >= 0; i--) {
            adjustHeap(A, i, n);
        }
        for (int j = n - 1; j > 0; j--) {  //没有等于
            swap(A, 0, j);
            adjustHeap(A, 0, j);
        }
        return A;
    }

    public static void swap(int[] A, int a, int b){
        int temp = A[a];
        A[a] = A[b];
        A[b] = temp;
    }

    public static void adjustHeap(int[] A, int i, int n){
        int temp = A[i];
        for (int k = 2*i+1; k < n; k = 2*k+1){  //没有=
            if (k + 1 < n && A[k] < A[k+1]){
                k++;
            }

            if (A[k] > temp){
                A[i] = A[k];
                i = k;
            }else {
                break;
            }

        }
        A[i] = temp;
    }

    public static void main(String[] args){
        int[] a = {51, 46, 20, 18, 65, 97, 82, 30, 77, 50};
        heapSort(a, a.length);
        for (int i = 0; i < a.length; i++){
            System.out.println(a[i]);
        }
    }

}
//参考:https://www.cnblogs.com/chengxiao/p/6129630.html