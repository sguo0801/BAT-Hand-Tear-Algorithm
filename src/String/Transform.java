package String;
//变形词.数组实现(放取)
import java.util.*;

public class Transform {
    public boolean chkTransform(String A, int lena, String B, int lenb) {
        if (lena == 0 || lenb == 0 || lena != lenb){
            return false;
        }
        //先把字符串变成字符数组.这些可以当做数组的索引使用,先放,再取.
        char[] charsA = A.toCharArray();
        char[] charsB = B.toCharArray();
        //255就够用啦,对于ASCII码来说.
        int[] map = new int[255];
        //开始往里面填
        for (int i = 0; i < charsA.length; i++){
            map[charsA[i]]++;   //把字符当做map的索引,每看到一个就自加一
        }
        for (int i = 0; i < charsB.length; i++){
            //如果找这个字符索引,没有 或者 数目不够,则返回false.
            if (map[charsB[i]]-- == 0){
                return false;
            }
        }
        return true;

    }
}