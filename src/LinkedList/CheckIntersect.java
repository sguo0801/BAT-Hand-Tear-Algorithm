package LinkedList;

import java.util.*;

//无环单链表判断是否相交,因为相交的话其实就是两个链表重合啦,所以可以先让长链表肆无忌惮走到与短链表长度一致的地方,
// 再一起遍历看有无相等,这样不仅可以判断是否相交,还可以得到在哪里相交
//时间复杂度为o(n+m),空间复杂度为o1.
//下面方法是用判断最后一个节点是否相同作为相交的判断标准.因为如果相交,后面必定有公共节点.但是这种方法不知道在哪里相交.
/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
public class CheckIntersect {
    public boolean chkIntersect(ListNode headA, ListNode headB) {
        //有一方头结点为空.则直接不相交,####一般!=与&&一块用###==与||一起用####
        if (headA != null && headB != null) { //这里是头结点都不为空才往下进行.
            ListNode curA = headA;
            //这边是看下一个指针地址是否为空,来看当前是否已经到了最后一个节点,更新curA才能往下移动
            while (curA.next != null) {
                curA = curA.next;  //这里是要头结点为headA的最后一个节点.
            }
            ListNode curB = headB;
            while (curB.next != null) {
                curB = curB.next;  //这里是要头结点为headB的最后一个节点.
            }
            return curA == curB;
        }
        return false;  //这边不用else也可以
    }
}