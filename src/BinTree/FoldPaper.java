package BinTree;
import java.util.*;
//折痕问题??
public class FoldPaper {
    public String[] foldPaper(int n) {
        List<String> list = new ArrayList<>();
        fold(1, n, true, list);
        String[] strings = new String[list.size()];
        for (int i = 0; i < list.size(); i++){
            strings[i] = list.get(i);
        }
        return strings;
    }
    private void fold(int i, int n, boolean down, List<String> list){
        if (i >n){
            return;
        }
        fold(i + 1, n, true, list);
        list.add(down ? "down" : "up");
        fold(i + 1, n, false, list);
    }
}