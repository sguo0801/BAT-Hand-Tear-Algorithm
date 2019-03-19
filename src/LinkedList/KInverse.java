package LinkedList;

import java.util.*;
// 链表的k逆序循环.不是很懂实现的思路!!!!!!???????
//这里没有使用栈.空间复杂度on1,用栈的话空间复杂度为onk.
/*
public class ListNode {
    int val;
    ListNode next = null;
    ListNode(int val) {
        this.val = val;
    }
}*/
public class KInverse {
    public ListNode inverse(ListNode head, int k) {
        ListNode cur = head;
        int count = 0;
        //这一步开始在原链表上分段.每k个划分一段,进行递归逆序.
        while (cur != null && count != k) {
            cur = cur.next;
            count++;
        }
        //这时cur为为k+1个节点.
        if (count == k) {
            cur = inverse(cur, k);
            //开始逆序
            while (count-- > 0) {
                ListNode temp = head.next;
                head.next = cur;     //每个head.next是最终链表的数据
                cur = head;
                head = temp;
            }
            //cur为反转后的第一个节点.
            head = cur;
        }
        return head;
    }
}