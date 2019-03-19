package Sort;

import java.util.*;
//重复值判断
public class Checker {
    public boolean checkDuplicate(int[] a, int n) {
        Arrays.sort(a);
        for (int i = 1; i < n; i++) {
            if (a[i] == a[i - 1]) {
                return true;
            }
        }
        return false;
    }
}
//堆排序自己熟悉,此为取巧方法