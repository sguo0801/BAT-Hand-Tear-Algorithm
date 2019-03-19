package Stack;
import java.util.*;
//栈的翻转练习.递归方法,一个get(),每层留一个,最后可以去除栈底元素,一个reverse,得到栈底元素再压回栈
//这里是另一种递归方法,直接调用reverseStack().
public class StackReverse {
    public int[] reverseStack(int[] A, int n) {
        if (n == 0){
            return A;  //这边返回null或者A 都可以,因为A只是做参数引进来,原来的不影响.
        }
        char[] c = null;
        int temp = A[n-1];
        //,每次都把最后一个数拿出来,然后前面的在递归,目的是把每个最后的数放在与之序号相反的地方,比如索引n-1变成0,最后也是0变成n-1.
        reverseStack(A, n - 1);
        A[A.length - n] = temp;
        return A;
    }

}