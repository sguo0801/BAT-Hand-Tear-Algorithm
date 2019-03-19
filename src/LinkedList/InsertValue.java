package LinkedList;
import java.util.*;
//环形链表插值
/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
public class InsertValue {
    public ListNode insert(int[] A, int[] nxt, int val) {
        //原始链表为空或者长度为0;则返回要插入的节点即可.
        if (A == null || A.length == 0){
            return new ListNode(val);
        }
        ListNode root = new ListNode(A[0]);
        //把指针指向自己.一个单节点链表;
        root.next = root;
        ListNode cur = root;
        //建立循环链表,将nxt指针数组作为指向A的索引.
        for (int i = 0; i < A.length - 1; i++){
            ListNode node = new ListNode(A[nxt[i]]);
            //next指的是上一次的node.
            cur.next = node;  //根节点出来指向新节点
            cur = node;    //使当前cur为新节点
            //node.next = root;   //新节点要指回根节点.不用写???
        }
        ListNode pre = root;
        ListNode next = root.next;
        ListNode node = new ListNode(val);
        //这边是如果指定要插入的节点数据小于根节点,那么插入的值为根节点,因为本身原链表有序.
        if (root.val >= node.val){   //等于的也放在根节点的前面.
            node.next = root;
            return node;
        }
        //要注意next是否为空??不是很理解
        while (next != null && node.val > next.val){  //只要新节点数据比next大,则调整pre并更新next.相当于节点向后移动.
            pre = next;   //如果大于最后一个节点,那么next.next是root吗?这样岂不是无限循环下去?还是此时链是断的,所以不需要写末端节点的next指向root???
            next = next.next;
        }
        //如果<=更新后next节点的数据,且大于root或者更新后的pre节点的数据,则插入
        node.next = next;  //这两个前后指针链接怎么顺序都可以.
        pre.next = node;
        return root;
    }
}