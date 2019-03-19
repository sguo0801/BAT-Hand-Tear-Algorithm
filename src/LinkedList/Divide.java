package LinkedList;
import java.util.*;
//链表排序 没搞明白!!!
/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
public class Divide {
    public ListNode listDivide(ListNode head, int val) {
        if (head == null || head.next ==null){
            return head;
        }
        //生成两个新的链表,大数链表和小数链表.且都为空头(无数据);
        ListNode tem = new ListNode(-1);  //-1是空表头,并无此数.
        ListNode pHead = new ListNode(-1);
        ListNode p = pHead;   //pHead是小数节点.
        ListNode q = head;
        ListNode t = tem;   //tems是大数节点
        pHead.next = q;
        while (q != null){  //这边就是链表遍历
            if (q.val > val){
                t.next = q;
                p.next = q.next; //这边将小数指针向后移,因为,中间的数大,放到了t中.
                q.next = null;
                t = t.next;   //大数节点有数了,所以后移;
                q = p.next;    //###这里不清楚!!
            }else {
                p = q;
                q = q.next;
            }
        }
        p.next = tem.next;   //进行大数小数连接.
        return pHead.next;  //返回去掉空头的剩下部分
    }
}