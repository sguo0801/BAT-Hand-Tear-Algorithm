package Stack;

import java.util.*;
//双栈成队列题目.保证两点,pop弹出栈不为空时,push栈不能倒入;其次,每次push栈倒入pop栈必须全部注入,否则pop栈不能弹出且push栈不能进新节点.
public class TwoStack {
    public int[] twoStack(int[] ope, int n) {
        //在方法里面,所以不能私有化变量.
        Stack<Integer> pushStack = new Stack<>();
        Stack<Integer> popStack = new Stack<>();
        int index = 0;
        for (int i = 0; i < n; i++) {
            if (ope[i] != 0) {
                pushStack.push(ope[i]);
            } else {
                index++;
            }
        }
        //只要pushStack不为空,就一直倒,while表示循环,if是条件,别乱用.
        while (!pushStack.empty()) {
            popStack.push(pushStack.pop());
        }
        //得先有个数组,然后最后装完popStack弹出的值作为返回序列.
        // 数组可以新建为null,但是不能使用这个数组,因为null只说明有这个指针,没有分配内存空间,而数组 = {}也不行,因为内存空间为0,依然用不了.
        int[] res = new int[index];
        for (int i = 0; i < index; i++) {
            res[i] = popStack.pop();
        }
        return res;
    }
}