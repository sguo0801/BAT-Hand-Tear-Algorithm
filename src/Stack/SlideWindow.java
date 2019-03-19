package Stack;

import java.util.*;

//这里是on(n*w)时间复杂度的算法.左神的算法后面要再研究.
public class SlideWindow {
    public int[] slide(int[] arr, int n, int w) {
        int[] res = new int[n - w + 1];
        int start = 0;
        int end = w;
        while (end <= n) {
            //此处注意max要放在循环里面,虽然它可能会小于新窗内的数,但是初始值要一直选在窗内的元素,因为每换窗口,max都会变化.
            int max = arr[start];
            for (int i = start; i < end; i++) {
                if (max < arr[i]) {
                    max = arr[i];
                }
            }
            res[start] = max;
            end++;
            start++;
        }
        return res;
    }
}