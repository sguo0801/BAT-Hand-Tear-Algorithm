package LinkedList;
import java.util.*;

//判断两个最普通的链表是否相交.
//1先找到入环节点
//2如果有一个链表有环另一个却没有，则不能相交。
// 若都无环，则算出长度让锻炼表先走长度差。
// 若都有环，先看入环节点是否相同，再分别处理
/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
public class ChkIntersection1 {
    public boolean chkInter(ListNode head1, ListNode head2, int adjust0, int adjust1) {
        //优先把头结点为空的情况去掉!省着后面麻烦!!
        if (head1 == null || head2 == null){
            return false;  //任意链表为空,则不会相交.
        }
        ListNode loopHead1 = chkLoop(head1);
        ListNode loopHead2 = chkLoop(head2);
        //这里是有一个有环,一个没环,则不可能相交
        if ((loopHead1 != null && loopHead2 == null) || (loopHead1 == null && loopHead2 != null)){
            return false;
            //这边不需要写loopHead2==null,因为前面一个有环链表,一个没有环的链表情况已经筛选过;现在loopHead1==null,则说明另一个肯定不会有环,只能为空.
        }else if (loopHead1 == null){
            //这里是两个单链表都没有环,则看两个链表最后一个节点是否相同即可判断两单链是否相交(这个方法不能找出相交点).
            ListNode cur1 = head1;
            ListNode cur2 = head2;
            while (cur1.next != null){ //这里是遍历head1为头结点的单链表
                cur1 = cur1.next;  //直到cur1的下一个节点为null,则说明cur1为此链表最后一个节点.
            }
            while (cur2.next != null){ //这里是遍历head2为头结点的单链表
                cur2 = cur2.next;  //直到cur2的下一个节点为null,则说明cur2为此链表最后一个节点.
            }
            return cur1 == cur2;
        }else {  //剩下就是两个都是环链表
            if (loopHead1 == loopHead2){
                return true;  //这里是环节点相同,则必然相交,相交点可能在入环点,也可能在入环点之前.
            }
            //入环点不同,则可能是两个完全不沾边的链,也可能是在环中相交.
            ListNode cur = loopHead1.next;
            while (cur != loopHead1) {  //遍历这个环
                if (cur == loopHead2) {
                    return true;
                }
                cur = cur.next;
            }
            return false;
        }
    }

    public static ListNode chkLoop(ListNode head){
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {  //这里就是遍历.
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) {  //说明肯定有环
                fast = head;
                while (fast != slow) {
                    fast = fast.next;
                    slow = slow.next;
                }
                return fast;
            }
        }
        //说明没有环,则返回null.
        return null;
    }
}