package Stack;

import java.util.*;

//不是很理解父亲节点的编号是怎么来的???
//不是很懂o(╥﹏╥)o
public class MaxTree {
    public int[] buildMaxTree(int[] A, int n) {
        int[] res = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            //这里是建立了一个栈,然后将栈顶元素跟原数组中的元素挨个作比较,哪个小哪个出栈.
             //比较的都是原数组.这里是如果栈顶元素作为索引的原数组中元素比原数组中小,则弹出,但是第一次栈中空.
            while (! stack.empty() && A[stack.peek()] < A[i]) { //是 并 的关系
                stack.pop();
            }
            //这里是栈中为空,说明左边比原数组中元素大的值没有,或者是左边数第一个元素.
            if (stack.empty()) {
                res[i] = -1;
            } else {  //这边是栈中有元素,且不比原数组中元素小,则新数组res中对应位置,左边第一个大的元素即为此时栈顶元素
                res[i] = stack.peek();
            }

            //这里开始操作不是很懂??压栈目的??前面的for循环是指找左边大值的操作吗?
            stack.push(i);  //跟编号有关系??
        }
        stack.clear();
        //原理不清楚,但是确实计算是对的
        for (int i = n-1; i >= 0; i--){  //注意从大到小,要有0.
            while (! stack.empty() && A[stack.peek()] < A[i]){
                stack.pop();
            }
            if (! stack.empty() && (res[i] == -1 || A[stack.peek()] < A[res[i]])){
                res[i] = stack.peek();
            }
            stack.push(i);
        }
        return res;
    }
}