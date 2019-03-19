package BinTree;
import java.util.*;
//寻找错误节点练习题
/*
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;
    public TreeNode(int val) {
        this.val = val;
    }
}*/
public class FindErrorNode {
    public int[] findError(TreeNode root) {
        int[] arr = new int[2];
        arr[0] = Integer.MAX_VALUE;
        arr[1] = Integer.MIN_VALUE;
        dfs(root, arr);
        return arr;
    }
    //题目是把中序遍历进行改造.
    private void dfs(TreeNode root, int[] arr){
        if (root == null){
            return;
        }
        dfs(root.left, arr);
        if (root.val < arr[1]){
            arr[0] = Math.min(arr[0], root.val);
        }
        else {
            if (arr[0] == Integer.MAX_VALUE){
                arr[1] = root.val;
            }
        }
        dfs(root.right, arr);
    }
}