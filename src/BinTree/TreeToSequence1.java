package BinTree;
import java.util.*;
//非递归实现先序遍历,中序遍历,后序遍历???再看!!

/*
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;
    public TreeNode(int val) {
        this.val = val;
    }
}*/
public class TreeToSequence1 {
    public int[][] convert(TreeNode root) {
        // write code here
        Stack<TreeNode> s = new Stack<TreeNode>();
        List<Integer> arr1 = new ArrayList<Integer>();
        List<Integer> arr2 = new ArrayList<Integer>();
        List<Integer> arr3 = new ArrayList<Integer>();
        first(root, arr1, s);
        mid(root, arr2, s);
        last(root, arr3, s);
        int[][] arr = new int[3][arr1.size()];
        for (int j = 0; j < arr1.size(); j++) {
            arr[0][j] = arr1.get(j);
        }
        for (int j = 0; j < arr2.size(); j++) {
            arr[1][j] = arr2.get(j);
        }
        for (int j = 0; j < arr3.size(); j++) {
            arr[2][j] = arr3.get(j);
        }
        return arr;
    }

    public void first(TreeNode root, List<Integer> list, Stack<TreeNode> s) {
        if (root == null) return;
        s.push(root);
        TreeNode c;
        while (!s.isEmpty()) {
            c = s.pop();
            list.add(c.val);
            if (c.right != null)
                s.push(c.right);
            if (c.left != null) {
                s.push(c.left);
            }
        }
    }

    public void mid(TreeNode root, List<Integer> list, Stack<TreeNode> s) {
        if (root == null) return;
        //
        TreeNode c = root;
        while (!s.isEmpty() || c != null) {

            while (c != null) {
                s.push(c);
                c = c.left;
            }
            TreeNode node = s.pop();
            list.add(node.val);
            c = node.right;
        }
    }

    public void last(TreeNode root, List<Integer> list, Stack<TreeNode> s) {
        TreeNode h, c = null;
        h = root;
        s.push(h);
        while (!s.isEmpty()) {
            c = s.peek();
            if (c.left != null && h != c.left && h != c.right) {
                s.push(c.left);
            } else if (c.right != null && h != c.right) {
                s.push(c.right);
            } else {
                h = s.pop();
                list.add(h.val);
            }
        }
    }
}