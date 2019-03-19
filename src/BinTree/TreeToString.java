package BinTree;
import java.util.*;
//二叉樹序列化
/*
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;
    public TreeNode(int val) {
        this.val = val;
    }
}*/
public class TreeToString {
    public String toString(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        TreeNode p = root;
        Stack<TreeNode> stack = new Stack<>();
        while (p != null || !stack.empty()){
            if (p != null){
                sb.append(p.val).append("!");
                stack.push(p);
                p = p.left;
            }else {
                sb.append("#!");
                TreeNode pop = stack.pop();
                p = pop.right;
            }
        }
        sb.append("#!");
        return sb.toString();
    }
}