package BinTree;
import java.util.*;
//判断完全二叉树
/*
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;
    public TreeNode(int val) {
        this.val = val;
    }
}*/
public class CheckCompletion {
    public boolean chk(TreeNode root) {
        if (root == null){
            return true;
        }
        if (root.left == null && root.right != null){   //接下来右边要等于空,或者足有都不等于空
            return false;
        }
        if (root.left == null){  //这边只有左边等于空.但是右边也为空.
            return true;
        }else if (root.right == null){
            return true;
        }else {
            return chk(root.right) && chk(root.left);
        }
    }
}