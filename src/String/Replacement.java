package String;
import java.util.*;
//空格替换练习
public class Replacement {
    //这里是String,所以不能改变长度,要注意
    public String replaceSpace(String iniString, int length) {
        int num = 0;
        for (int i = 0; i <length; i++){
            if (iniString.charAt(i) == ' '){
                num += 2;
            }
        }
        char[] rpc = new char[length + num];
        int j = length+num-1;
        //注意i>=0,要遍历全
        for (int i = length-1; i >= 0; i--){
            if (iniString.charAt(i) == ' '){
                rpc[j--] = '0';
                rpc[j--] = '2';
                rpc[j--] = '%';
            }else {
                rpc[j--] = iniString.charAt(i);
            }
        }
        return String.valueOf(rpc);
    }
}