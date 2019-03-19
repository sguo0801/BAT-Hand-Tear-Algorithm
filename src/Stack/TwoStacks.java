package Stack;
import java.util.*;
//双栈排序
public class TwoStacks {
    public ArrayList<Integer> twoStacksSort(int[] numbers) {
        int n = numbers.length;
        int cur; //存放临时值
        int i = 0;   //排序栈的索引,开始在栈顶
        int j = n;   //辅助栈的索引,开始在栈的下面,
        int[] help = new int[n];   //辅助栈的建立
        //最多到n-1,那时栈会被取空.
        while (i < n){
            //还是要先放到cur中,尽管是第一次,规矩不能乱
            cur = numbers[i++];
            //第一次肯定放入help中.
            if (j == n){
                help[--j] = cur;//此时放在了help[n-1].
            }else if (cur <= help[j]){
                help[--j] = cur;
            }else {  //这时候想办法把help中弹出来,返回number中.直到help栈顶>cur
                while (j < n && cur > help[j]) {
                    numbers[--i] = help[j++];    //##前面栈顶元素给cur,i++啦,所以此处先减回来
                }
                help[--j] = cur;
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (int k = 0; k < n; k++) {
            list.add(help[n - k - 1]);
        }
        return list;
    }
}