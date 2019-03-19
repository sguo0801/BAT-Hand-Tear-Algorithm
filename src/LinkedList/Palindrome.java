package LinkedList;

import java.util.*;

//判断是否为回文结构.next就是指针,不要单纯的往后一位想
/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
public class Palindrome {
    public boolean isPalindrome(ListNode pHead) {
        if (pHead == null || pHead.next == null){
            return true;
        }
        ListNode pfast = pHead;
        ListNode pslow = pHead;
        while (pfast != null && pfast.next != null) {  //为什么不是.next.next!=null???跟左神不同????
            pfast = pfast.next.next;   //快指针每次移动两位.
            pslow = pslow.next;  //满指针每次移动一位.
        }
        ListNode prev = null;
        while (pslow != null) {  //满指针在中心,开始翻转剩下链表.不懂啦!!!!是把中心位置的指向null,作为右侧链表的尾巴???
            ListNode next = pslow.next;
            pslow.next = prev;
            prev = pslow;
            pslow = next;
        }
        ListNode pNode = pHead;  //相当于从头结点开始进行遍历.
        //判断从头开始,到中间;与从末尾开始到中间的这两个链表是否相等
        while (prev != null){
            if (pNode.val == prev.val){
                pNode = pNode.next;
                prev = prev.next;
            }else {
                return false;
            }
        }
        return true;
    }
}