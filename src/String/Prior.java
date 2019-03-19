package String;
//拼接最小字典序练习题
import java.util.*;

public class Prior {
    public String findSmallest(String[] strs, int n) {
        //这里是字符串数组,让strs中的字符串按照comparator的排序方法排序.
        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o1 + o2).compareTo(o2 + o1);
            }
        });
        //这里已经排序好了,然后直接进行遍历
        //注意null和""是不同的,这里不能用null
        String res = "";
        for (int i = 0; i < n; i++){
            res += strs[i];
        }
        return res;
    }
}