package String;
//旋转词
public class Rotation {
    public boolean chkRotation(String A, int lena, String B, int lenb) {
        if (lena != lenb) {
            return false;
        } else {
            return (A + A).contains(B);
        }
    }
}
//z这里取巧用了contains方法,该方法并不是KMP算法进行匹配的,是最简单的朴素匹配,即o(n*m),
// 但是其实只有最糟糕的情况,如类似文本串aaaaaaa与模式串aaaab,才会是时间复杂度o(n*m).