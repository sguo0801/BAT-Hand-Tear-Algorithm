package BinSearch;
import java.math.BigInteger;
import java.util.*;
//快速求取k的N次方,时间复杂度为o(logN).????mod求余函数作用???完全懵了!
public class QuickPower {
    public int getPower(int k, int N) {
        BigInteger res = BigInteger.valueOf(1);
        BigInteger tmp = BigInteger.valueOf(k);
        for (; N != 0; N >>= 1){  //这里是将N的二进制右移1位,然后赋值给N;
            if ((N & 1) != 0){  //说明N=0??
                res = res.multiply(tmp);
            }
            tmp = tmp.multiply(tmp);
            res = res.mod(BigInteger.valueOf(1000000007));  //两个取余运算.rem结果的符号与被除数相同；mod结果的符号与除数相同。
            tmp = tmp.mod(BigInteger.valueOf(1000000007));
        }
        return res.mod(BigInteger.valueOf(1000000007)).intValue();
    }
}