package LinkedList;

import java.util.*;

//有环单链表是否相交.
/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
public class ChkIntersection {
    public boolean chkInter(ListNode head1, ListNode head2, int adjust0, int adjust1) {
        //既然是有环链表,先找到入环第一个节点.再看是入环前相交的还是正好在入环点处相交的,再或者,入环点不同,但是是在环内相交.
        ListNode loopNode1 = chkLoop(head1);
        ListNode loopNode2 = chkLoop(head2);  //拿到两个入环点,当然如果题中没有说有环,可能其中一个为null.
        if (loopNode1 == loopNode2){
            return true;  //如果入环点相同,则肯定是相交的.且可能相交的点在入环点之前或者就是入环点.
        }else {  //入环点不同,则说明是肯定在环内相交.
            ListNode cur = loopNode1.next;
            while (cur != loopNode1){  //绕环一周.
                if (cur == loopNode2){
                    return true;
                }
                cur = cur.next;
            }
            return false;  //绕场一圈没看到,说明两个环链表一点都没连着.各有各的环.
        }
    }

    //链表是否有环,返回环链表的乳环第一个节点. static方法可以直接 类.方法 进行调用,不加的话为动态方法,必须new一个对象才能用.
    public  static ListNode chkLoop(ListNode head) {
        //最起码也要两个非空才能成环为环链表.
        if (head == null && head.next == null) {
            return null;   //如果满足条件,执行return直接退出程序.后面就不运行啦
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {  //这边条件不能反着写.先写前一个节点,再写后一个节点.
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {  //说明有环
                fast = head;
                while (fast != slow) {
                    fast = fast.next;
                    slow = slow.next;
                }
                return fast;
            }
        }
        return null;  //可以循环完,说明没有环.
    }
}
