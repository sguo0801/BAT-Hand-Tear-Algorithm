package LinkedList;
import java.util.*;
//单链表是否有环.时间复杂度为on,空间复杂度为o1.一般这种空间复杂度就是不额外提供容器,通过指针和数学算法来解决.
/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
public class ChkLoop {
    public int chkLoop(ListNode head, int adjust) {
        ListNode fast = head;
        ListNode slow = head;  //定义两个快满指针.都是从头结点开始.
        //如果快速指针能直接到空,说明没有环.否则即为有环,无需考虑是否链表为空的情况.
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast){   //这里是条件,whlie与if不要混!!第一次相遇的地方作为一个关键点.且有环则一定能相遇
                fast = head;   //这边把fast调到头结点,再快慢节点都以慢速行走.
                while (fast != slow){
                    //只要没遇到就再走,这边是循环
                    fast = fast.next;
                    slow = slow.next;
                }
                return fast.val;  //当再次相遇的节点即为环的起始结点,可用数学方法证明,不是很清楚.
            }
        }
        return -1;  //这边是说明fast指针已经到了null,即无环,根据题意为-1.
    }
}