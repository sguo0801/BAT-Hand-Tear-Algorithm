package String;
//拓扑结构相同子树
//参考:http://www.ruanyifeng.com/blog/2013/05/Knuth%E2%80%93Morris%E2%80%93Pratt_algorithm.html
//参考:https://blog.csdn.net/x__1998/article/details/79951598
//参考:https://blog.csdn.net/starstar1992/article/details/54913261/

//整个流程是这样:首先有模式串,和判断是否包含该模式串的文本串,先调用kmpnext()通过模式串计算部分匹配值(一个长度与模式串相同的数组),
//再调用getIndexOf()方法通过文本串,模式串和部分匹配值(那个数组),求出文本串包含模式串的第一个索引,从而判断文本串是否包含模式串.
public class KMP {
    //返回的是开始包含模式串的初始索引值
    public static int getIndexOf(String str, String desk, int[] next){     //str为文本串,desk为模式串,就是小的二叉树等待匹配.
        //是文本穿的索引,j是模式串的索引.
        for (int i = 0, j = 0; i < str.length(); i++){
            while (j > 0 && str.charAt(i) != desk.charAt(j)){
                //求next数组就是字符串匹配的过程.
                j = next[j - 1];
            }
            if (str.charAt(i) == desk.charAt(j)){
                j++;
            }
            if (j == desk.length()){
                return i-j+1;
            }
        }
        return 0;
    }
    //通过模式串求得部分匹配值next数组.长度与模式串相同.
    public static int[] kmpnext(String dest){
        int[] next = new int[dest.length()];
        next[0] = 0;      //代表模式串第一个元素,前后缀为空,所以 =0.
        //i是模式串的索引
        for (int i = 1, j = 0; i < dest.length(); i++){
            while (j > 0 && dest.charAt(i) != dest.charAt(j)){
                j = next[j -1];
            }
            if (dest.charAt(i) == dest.charAt(j)){
                j++;
            }
            next[i] = j;
        }
        return next;
    }
    public static void main(String[] args){
        String a = "ababa";
        String b = "ssdfgasdbababa";
        int[] next = kmpnext(a);
        int res = getIndexOf(b, a, next);
        System.out.println(res);
        for(int i = 0; i < next.length; i++){
            System.out.println(next[i]);
        }
        System.out.println(next.length);
    }
}
//要再研究!!
