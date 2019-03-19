package String;
import java.util.*;
//合法括号练习题
public class Parenthesis {
    public boolean chkParenthesis(String A, int n) {
        //注意判断是否为null和长度是否太短,
        if (A == null || n == 0){
            return false;
        }
        int num = 0;
        for (int i = 0; i < n; i++){
            if (A.charAt(i) == '('){
                num++;
            }else if (A.charAt(i) == ')'){
                num--;
            }
        }
        if (num == 0){
            return true;
        }else {
            return false;
        }
    }
}