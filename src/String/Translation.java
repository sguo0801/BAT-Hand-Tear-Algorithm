package String;
//字符串移位练习
import java.util.*;

public class Translation {
    public String stringTranslation(String A, int n, int len) {
        char[] c = A.toCharArray();
        //先将前len前缀的字符进行倒叙,然后再讲后面的字符进行倒叙,最后整体倒序即可.
        //注意题干,长度为len的前缀,那么交换分割的是len-1的索引.
        reverse(c, 0, len-1);
        reverse(c, len, n-1);
        reverse(c, 0, n-1);
        return String.valueOf(c);
    }
    public static void reverse(char[] c, int begin, int end){
        while (begin < end){
            char temp = c[begin];
            c[begin] = c[end];
            c[end] = temp;
            begin++;
            end--;
        }
    }
}