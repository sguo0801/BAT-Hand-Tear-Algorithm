package LinkedList;
import java.util.*;
//访问单个节点的删除.
/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
public class Remove {
    public ListNode removeNode(ListNode pNode, int delVal) {
        if (pNode == null){   //单链为空,则返回空即可.
            return null;
        }

        //说明头结点的数据不是选定的,则不用删除
        if (pNode.val == delVal){
            return pNode.next;
        }
        //建立相当于两个指针. 一个是临时节点,一个是临时节点的下一个节点.
        ListNode temp = pNode;
        ListNode cur = temp.next;  //如果移除temp,则指针到这里.
        while (cur != null){  //找删除的点循环到未知节点为空,即到尾巴啦.到尾巴没有,说明链中没有此数据,则返回即可.##题目中没有重复的数字.###
            if (cur.val == delVal){
                temp.next = cur.next;  //相当于删除了cur,头指针(临时指针)直接指向了cur的下一个指针地址.
                break;  //跳出while循环.因为已经找到了并且已经删除.
            }
            temp = temp.next;   //因为没有重复的数字,头结点后面第一个节点,则temp后移.移到刚刚确定安全的节点上,主要是为了指针打算跳跃过被删除的节点.
            cur = cur.next;  //cur一直都在temp后面一个节点.这时头节点后面的节点已经安全.所以跟temp同时后移
        }
        return pNode;//成功删除并且跳出循环,根据题意返回头节点.
    }
}