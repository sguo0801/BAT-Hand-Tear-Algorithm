package BinTree;
import java.util.*;
//树上最远距离练习题.??
/*
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;
    public TreeNode(int val) {
        this.val = val;
    }
}*/
public class LongestDistance {
    public int findLongest(TreeNode root) {
        longest(root);
        return longest;
    }
    private  int longest = 0;
    public int longest(TreeNode root){
        if (root == null) {
            return 0;
        }
        int l = longest(root.left);
        int r = longest(root.right);
        longest = Math.max(longest, l + r + 1);
        return Math.max(l, r) + 1;
    }
}