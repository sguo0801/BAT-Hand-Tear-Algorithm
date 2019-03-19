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
public class TreeToSequence {
    public int[][] convert(TreeNode root) {
        //建立三个数组线性表来存储是那种遍历后的结果.ArrayList(数组队列)是一个内部控制动态增长的数组,而且所有参数都是Object类型的,而普通数组(Array)则可以指定类型
        //LinkedList主要保持数据的插入顺序的时候使用，采用链表结构；ArrayList，Vector都是使用的是长度可变的数组存储
        ArrayList pre = new ArrayList<TreeNode>();
        ArrayList in = new ArrayList<TreeNode>();
        ArrayList post = new ArrayList<TreeNode>();  //这边TreeNode放在后面??
        //三种遍历方法.
        preOrder(root, pre);
        inOrder(root, in);
        postOrder(root, post);
        int[][] nodes = new int[3][pre.size()];  //建立一个二维数组
        for (int i = 0; i < pre.size(); i++){
            nodes[0][i] = (Integer)pre.get(i);
            nodes[1][i] = (Integer)in.get(i);
            nodes[2][i] = (Integer)post.get(i);
        }
        return nodes;
    }
    public static void preOrder(TreeNode root, ArrayList<Integer> pre){
        if (root == null){
            return;
        }
        pre.add(root.val);
        preOrder(root.left, pre);
        preOrder(root.right, pre);
    }
    public static void inOrder(TreeNode root, ArrayList<Integer> in){
        if (root == null){
            return;
        }
        inOrder(root.left, in);
        in.add(root.val);
        inOrder(root.right, in);
    }
    public static void postOrder(TreeNode root, ArrayList<Integer> post){
        if (root == null){
            return;
        }
        postOrder(root.left, post);
        postOrder(root.right, post);
        post.add(root.val);
    }
}