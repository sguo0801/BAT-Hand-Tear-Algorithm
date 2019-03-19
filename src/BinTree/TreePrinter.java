package BinTree;
import java.util.*;

/*
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;
    public TreeNode(int val) {
        this.val = val;
    }
}*/
public class TreePrinter {
    public int[][] printTree(TreeNode root) {
        if (root == null){
            return null;
        }
        ArrayList<ArrayList<Integer>> nodes = new ArrayList<>();
        ArrayList<Integer> curLine = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>() ;
        queue.offer(root);
        TreeNode cur = null, last = root, nlast = null;
        while (!queue.isEmpty()) {
            cur = queue.poll(); //队列返回头的方法.
            curLine.add(cur.val);
            if (cur.left != null){
                queue.offer(cur.left);
                nlast = cur.left;
            }
            if (cur.right != null){
                queue.offer(cur.right);
                nlast = cur.right;
            }
            if (cur == last){  //节点等于last,说明到达了当前行最后一个节点.
                nodes.add(curLine);
                last = nlast;
                curLine = new ArrayList<>();
            }
        }
        int[][] result = new int[nodes.size()][];
        for (int i = 0; i < nodes.size(); i++){
            curLine = nodes.get(i);
            result[i] = new int[curLine.size()];
            int j = 0;
            for (Integer num : curLine){
                result[i][j++] = num;
            }
        }
        return result;
    }
}