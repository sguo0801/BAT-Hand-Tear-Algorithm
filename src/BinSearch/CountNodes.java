package BinSearch;
import java.util.*;
//完全二叉树的节点数.时间复杂度为o(Math.pow(h,2)).
/*
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;
    public TreeNode(int val) {
        this.val = val;
    }
}*/
public class CountNodes {
    public int count(TreeNode root) {
        if (root == null){
            return 0;
        }
        int count = 1;  //默认有头结点.
        TreeNode temp = root.left;
        //这边是获得层数,
        int zuoTree = 0;
        while (temp != null){
            temp = temp.left;
            zuoTree++;
        }
        temp = root.right;
        int youTree = 0;
        while (temp != null){
            temp = temp.left;
            youTree++;
        }
        //如果左右层数相同的话,说明左子树是完整的二叉树.
        if (youTree == zuoTree && zuoTree != 0){
            count = (int)Math.pow(2, zuoTree) + count(root.right);  //递归取得右子树的节点个数,左边满直接2的高度平方即可.
        }else {  //这边是右边为满的子树.
            count = (int)Math.pow(2, youTree) + count(root.left);  //一般树都跟递归有关.
        }
        return count;
    }
}