package LinkedList;
//链表节点两个值,一个val代表里面的数据,一个next代表里面的指针.
public class ListNode {
    int val;
    //next相当于是一个变量,实质上是指针.
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
