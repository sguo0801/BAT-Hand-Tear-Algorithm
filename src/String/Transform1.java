package String;
//变形词.建立两个哈希表,最后看是不是相等. 对比单纯使用数组,这种方法占用更多内存,并且运行更久,但是更好理解.
import java.util.*;

public class Transform1 {
    public boolean chkTransform(String A, int lena, String B, int lenb) {
        //用哈希表,key为字符串里的字符,value为有几个的个数.
        HashMap<Character, Integer> hashMapA = new HashMap<>();
        HashMap<Character, Integer> hashMapB = new HashMap<>();
        for (int i = 0; i < A.length(); i++){
            if (hashMapA.containsKey(A.charAt(i))){
                //使那个键对应的值+1.
                hashMapA.put(A.charAt(i), hashMapA.get(A.charAt(i)) + 1);
            }else {
                //从来没出现过的字符,就建立一个key-value,并使value置为1;
                hashMapA.put(A.charAt(i), 1);
            }
        }
        //同理把第二个字符串也建立一个哈希表.
        for (int i = 0; i < B.length(); i++){
            if (hashMapB.containsKey(B.charAt(i))){
                hashMapB.put(B.charAt(i), hashMapB.get(B.charAt(i)) + 1);
            }else {
                hashMapB.put(B.charAt(i), 1);
            }
        }
        if (hashMapA.equals(hashMapB)){
            return true;
        }else {
            return false;
        }
    }
}