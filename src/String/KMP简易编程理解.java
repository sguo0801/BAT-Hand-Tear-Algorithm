package String;

public class KMP简易编程理解 {
    //第一步,先求一个串(指模式串从小到大的过程中的子串)的部分匹配值
    private static int calcMatchValue(String subStr) {
        int length = subStr.length();
        //前缀先用模式串扣掉最后一个字符,后缀则是模式串扣掉第一个字符.
        String preFixStr = subStr.substring(0, length - 1);
        String suffFixStr = subStr.substring(1);
        //只要前后缀还在 就看是否相等,一般是不相等,如果相等那就是缩到位啦,从最长往最短缩,所以只要相等即弹出最长的共有元素的长度.
        while (preFixStr.length() > 0 && suffFixStr.length() > 0) {
            if (preFixStr.equals(suffFixStr)) {
                return preFixStr.length();
            }
            //这种情况只有两个元素(前后缀各有一个元素),还不相等,那么不需要再缩了,直接弹出,部分匹配值为0,模式串再加一位,再计算下一个新串的部分匹配值.
            if (preFixStr.length() == 1 && suffFixStr.length() == 1) {
                break;
            }
            //因为一般不相等,则现在前后缀都缩一位,(有点像i++的意思,然后再进while循环,看新的前后缀有没有部分匹配值.
            preFixStr = preFixStr.substring(0, preFixStr.length() - 1);
            suffFixStr = suffFixStr.substring(1, suffFixStr.length());
        }
        return 0;
    }
    //第二步,开始把模式串的部分匹配表(数组)求出来.
    private static int[] createPartialMatchTable(String pattern) {
        //部分匹配表长度与模式串长度一致.
        int patternLen = pattern.length();
        int[] matchTable = new int[patternLen];
        //部分匹配表的索引(也是模式串的索引),还有每个子串对应的部分匹配值
        int i = 0;
        int matchValue = 0;  //初始都为0;
        //所以i不能超过模式串的索引.
        while (i < patternLen) {
            if (i == 0) {
                matchValue = 0;    //当i==0时,说明,子串就是第一个元素,没有前后缀,默认为0.
            } else {
                //每求出一个子串的模式匹配值,进入循环,索引满足要求,即模式串还有剩,将子串加一个元素
                matchValue = calcMatchValue(pattern.substring(0, i + 1));  //substring()方法左闭右开,所以i=1时,是索引对应0和1的前两个元素.
            }
            matchTable[i] = matchValue;
            i++;
        }
        return matchTable;
    }
    //第三步,根据部分匹配表,文本串和模式串
    private static boolean kmp(String target, String pattern) {
        int[] partialMatchTable = createPartialMatchTable(pattern);  //根据模式串求出部分匹配表

        char[] targetCharArr = target.toCharArray();      //文本串变成字符数组,准备进行比较
        char[] patterncharArr = pattern.toCharArray();    //模式串变成字符数组,准备进行比较
        int matchCharCounts = 0;// 记录下已经匹配的字符的个数

        int i = 0, j = 0, moveCounts = 0;
        while (i < targetCharArr.length) {

            // 如果当前主串和子串的字符匹配上了 那么比较下一个字符是否匹配
            if (targetCharArr[i] == patterncharArr[j]) {
                matchCharCounts++;
                i++;
                j++;   //只要匹配上索引就开始移动,j的目标是能够==模式串的长度,那么久说明模式串完整的匹配上啦.
            }
            // j==0说明从开始到现在模式串第一个字符还没有匹配上,j就不动,i继续走着.
            else if (j == 0) {
                i++;
            }
            // 如果子串不是在第一个元素的位置而是在其他位置进行了失配，那么进行移位操作
            else {
                // 移动位数 = 已匹配的字符数 - 对应的部分匹配值
                // 对应匹配值,指的是最后一个匹配到的字符的对应匹配值,j是失配的位置,所以这里是partialMatchTable[j - 1]
                moveCounts = matchCharCounts - partialMatchTable[j - 1];
                j = j - moveCounts;//移动模式串,往前移moveCounts位,j现在相对模式串往回移动,再从前缀的屁股后面开始匹配
                matchCharCounts = matchCharCounts - moveCounts;//修改匹配的字符个数，就是减去移动过的位数
            }
            // 如果匹配成功了,直接返回true了,这里返回j的值,那么就是包含模式串的第一个所以你的位置.
            if (j == patterncharArr.length) {
                return true;
            }
        }
        return false;
    }
}

