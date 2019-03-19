package String;
import java.util.*;
//英文句子逆序
public class Reverse {
    public static String reverseSentence(String A, int n) {
        char[] c = A.toCharArray();
        reverse(c, 0, n-1);
        int begin = 0;
        for (int i = 0; i < n; i++){
            //从begin开始,遇到第一个空格,则之间的调换
            if (c[i] == ' '){
                reverse(c, begin, i-1);
                //重新设置begin的值;
                begin = i + 1;
                //这里是在最后,对最后的单词进行调换.当然如果i=1也被包括在里面
            }else if (i == n-1){
                reverse(c, begin, i);
            }
        }
        return String.valueOf(c);
    }
    public static void reverse(char[] c, int begin, int end){
        char temp = 0;
        while (begin < end){
            temp = c[begin];
            c[begin] = c[end];
            c[end] = temp;
            begin++;
            end--;
        }
    }
}