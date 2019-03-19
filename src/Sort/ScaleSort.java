package Sort;

import java.util.*;
//小范围排序
//数组几乎有序，每个元素调整次数不超过k。k对于数组长度来说很小。
//用什么排序较好。
//on2的算法 选择 冒泡与原始数列无关。插入不能保证移动次数少。
//onlogn的算法 归并 快排 与初始顺序无关。 所以堆排序比较合适。移动次数少。说明复杂度为onlogk。
//比起onlogn要小很多。
public class ScaleSort {
    public int[] sortElement(int[] A, int n, int k) {
        if (A == null || A.length == 0 || n < k ){
            return A;
        }
        //做一个小顶堆,由数组中k的元素组成,找其中最小值.
        int[] heap = getHeap(A, k);
        //要把小顶堆的顶返回,再插入新的原数组中的A[i],heap保存了还没弹出的数,可以直接在A[i]中放有序值,放了n-k个
        for (int i = k; i < n; i++) {
            A[i - k] = heap[0];    //新鲜出炉的最小值
            heap[0] = A[i];
            heapify(heap, 0, k);
        }
        //从i=k的时候开始弹出,到不往里面进的时候,最后堆中还有k个数没有弹出,要继续找最小的
        for (int i= n-k; i < n; i++){
            A[i] = heap[0];
            //已经没有数填进堆中,则将树的最后一个放到最前面来,然后再调整,且每一次堆中从后往前少一个数.
            swap(heap, 0, k-1);
            heapify(heap, 0, --k);   //每次调整的堆数组长度减少一个
        }
        return A;
    }

    //包括第一次和弹出最小值后的其他次,需要重新构建小顶堆,且除了第一次后的每次构建需要添加一个元素.
    public  int[] getHeap(int[] A, int k){
        //用数组中的前k个数建立小顶堆
        int[] heap = new int[k];
        for (int i = 0; i < k; i++){
            heapInsert(heap, A[i], i);
        }
        //返回变成小顶堆的heap
        return heap;
    }

    public void heapInsert(int[] heap, int value, int index) {
        //构成了堆
        heap[index] = value;
        //子节点小的话则交换,当索引为0时,则还没有子节点,注意避免越界异常
        while (index != 0){
            int parent = (index - 1) / 2;
            if (heap[parent] > heap[index]){
               swap(heap, parent, index);
            }else {
                break;
            }
        }
    }

    public void heapify(int[] arr, int index, int heapSize){
        //堆从顶端开始的左右子节点
         int left = 2*index + 1;
         int right = 2*index +2;
         int smallest = index;
         //左右节点把小值拿到上面,然后再往下面一层层传##有点懵##
         while (left < heapSize){
             if (arr[left] < arr[index]){   //应该是index,这样下一轮才会变??
                 //先不交换值,把最小值的索引确定
                 smallest = left;
             }
             if (right < heapSize && arr[right] < arr[smallest]){
                 smallest = right;
                 //说明索引变了,子节点有更小的值.
             }if (smallest != index){
                 swap(arr, smallest, index);
             } else{
                 break;
             }
             //下一层,看下面的完全二叉树,进行交换
             index = smallest;
             left = 2*index + 1;
             right = 2*index +2;
         }
    }

    public void swap(int[] A, int a, int b){
        int temp = A[a];
        A[a] = A[b];
        A[b] = temp;
    }
}
//小范围排序问题,不知道为什么通不过!