package Sort;
//有序矩阵中查找
import java.util.*;

public class Finder {
    public boolean findX(int[][] mat, int n, int m, int x) {
        //从整个矩阵的右上角开始查找,即第0行,最右边的列.m,n为固定数,得先把索引定义好.
        int row = 0;
        int column = m - 1;
        while (row < n && column >= 0){
            if (x == mat[row][column]){
                return true;
                //往左移一列,最右边去掉,以此类推
            }else if (x < mat[row][column]){
                column--;
                //往下移动一行,上面的行不要.
            }else {
                row++;
            }
        }
        return false;
    }
}