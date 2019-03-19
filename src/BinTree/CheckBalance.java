package BinTree;
import java.util.*;
//判断是否为平衡二叉树,空树也是平衡二叉树.递归
/*
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;
    public TreeNode(int val) {
        this.val = val;
    }
}*/
public class CheckBalance {
    public boolean check(TreeNode root) {
        return chk(root) >= 0;
    }
    private static int chk(TreeNode root){
        if (root == null){
            return 0;
        }
        int left = chk(root.left);  //左边深度.
        int right = chk(root.right);  // 右边深度
        if (left < 0 || right < 0){   //小于0,只有当两子树深度差大于1时,然后递归回来
            return -1;
        }
        if (Math.abs(left - right) > 1){
            return -1;
        }
        return left > right ? left+1 : right+1;  //???
    }
}