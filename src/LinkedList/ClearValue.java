package LinkedList;
import java.util.*;
//指定值删除的链表练习
/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
public class ClearValue {
    public ListNode clear(ListNode head, int val) {
        //这种返回链表头结点的问题,都要先判断头结点是否发生了变化.
        //这里如果头节点的数据即为val则头结点就要改变.
        while (head != null){    //先要循环看是否遍历完整个链表,如果头数据依次都等于val,则返回空,否则即确定了头结点.
            if (head.val != val){
                break;  //这边如果不是数据为val的节点,则直接跳出循环.
            }else {
                head = head.next;
            }
        }
        //pre是生成要的链表的节点.  cur是探路判断是否安全的jiedian,安全则pre=cur.不安全(比如删除),则pre不动.指针指向cur下一个节点.
        //无论是否安全,cur每次都要向后移.
        ListNode pre = head;  //删除操作都是要两个节点配合,一个确保安全的节点,一个该节点的下一个节点.
        ListNode cur = head;  //先都设置为头节点.
        while (cur != null){
            if (cur.val == val){
                pre.next = cur.next;    //删除基本操作.
            }else {
                pre = cur;  //说明安全!!
            }
            cur = cur.next;  //如果安全,cur直接后移,保证两个节点差一位,为后面做准备;如果不安全同样后移,原来的cur就扔掉了.
        }
        return head;  //之前判断了head的正确性,直接返回.
    }
}