package Stack;
import java.util.Stack;
//可弹出栈最小元素的min函数
public class Solution {
    private Stack<Integer> dataStack = new Stack<>();
    private Stack<Integer> minStack = new Stack<>();
    public void push(int node) {
        //排序栈正常压栈,最小栈是为空,则压栈,如果栈顶元素大于节点才会将新节点放进来.
        dataStack.push(node);
        //注意栈空是empty方法,而不是null
        if (minStack.empty() || minStack.peek() >= node){   //注意是>=,否则法一会在出栈时少节点,访问用栈顶指针peek(),栈顶是指进出的那段,栈不分上下.
            minStack.push(node);
        }else {
//            //方法一,不是比栈顶数小的节点不压进栈,法二,直接压栈顶的节点,这里是方法二.
//            minStack.push(minStack.peek());
        }
    }

    public void pop() {
        if (dataStack.empty()){
            throw new RuntimeException("排序栈已经空了");
        }else{
//            //弹出栈,只要不是空的就一起弹出就好了,因为法二是一样的节点数.
//            //法一的话,只要判断两个栈顶相等则最小栈弹出即可,排序栈是不管怎么样都要弹出的.
//            minStack.pop();
//            dataStack.pop();
            if (dataStack.peek() == minStack.peek()){ //法一
                minStack.pop();
            }
            dataStack.pop();
        }
    }

    public int top() {
        return dataStack.peek();
    }

    public int min() {
        if (minStack.empty()){
            throw new RuntimeException("最小栈空了");
        }
        return minStack.peek();
    }
}