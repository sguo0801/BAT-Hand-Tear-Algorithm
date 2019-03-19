package LinkedList;
import java.util.*;
//打印两个链表的公共值.
/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
public class Common {
    public int[] findCommonParts(ListNode headA, ListNode headB) {
        //作为存储比较后的公共值容器使用.
        LinkedList<Integer> list = new LinkedList();
        while (headA != null && headB != null){
            //s谁小谁后移,相等则都后移,知道任一链表为空.
            if (headA.val < headB.val){
                headA = headA.next;
            }else if (headA.val > headB.val){
                headB = headB.next;
            }else {   //这时两个节点的数据相等
                list.add(headA.val);
                headA = headA.next;
                headB = headB.next;
            }
        }
        int[] res = new int[list.size()];
        int index = 0;
        while (! list.isEmpty()){
            res[index++] = list.pollFirst();  //这边要注意链表要定义泛型.否则是Object.
        }
        return res;
    }
}