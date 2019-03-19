package String;

import java.util.*;

//最长无重复字符子串长度,有点懵!
public class DistinctSubstring {
    public int longestSubstring(String A, int n) {
        if (A == null || n == 0) {
            return 0;
        }
        char[] chas = A.toCharArray();
        int[] map = new int[256];
        for (int i = 0; i < 256; i++) {
            map[i] = -1;
        }
        int len = 0;
        int pre = -1;
        int cur = 0;
        for (int i = 0; i < n; i++) {
            pre = Math.max(pre, map[chas[i]]);
            cur = i - pre;
            len = Math.max(len, cur);
            map[chas[i]] = i;
        }
        return len;
    }
}
