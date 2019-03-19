package LinkedList;
//复杂链表的复制
/*
public class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}
*/
public class Solution {
    public RandomListNode Clone(RandomListNode pHead) {
        if (pHead == null){
            return null;
        }
        RandomListNode list = pHead;
        //第一遍遍历节点,每遍历一个节点,则复制相同的节点,并放在当前节点的下一个位置;
        while (list != null) {
            RandomListNode node = new RandomListNode(list.label);  //复制出新节点.
            node.next = list.next;  //将新复制好的节点指向原节点的下一个节点.
            list.next = node;  //再将原节点指向新复制的节点,相当于这两步把复制出来的新节点插到了原节点的后面.
            list = list.next.next;  //就是更新list到复制节点的下一个节点.
        }
        //第二遍遍历节点,设置新的random指针
        list = pHead;  //将list掰回头结点.重新遍历.
        while (list != null){
            if (list.random != null){
                list.next.random = list.random.next;
            }else {
                list.next.random = null;
            }
            list = list.next.next;
        }
        //第三遍遍历节点,还原原始链表,去除所有的新节点.最后用新链表的头部表示.
        list = pHead;
        RandomListNode newList = null;
        RandomListNode temp = null;
        RandomListNode res = null;  //这个节点是新链表的头部,所以只需要第一次从list中取出找到即可.作为后面的返回值.
        while (list != null){
            temp = list.next;  //作为两个链表的桥梁.找到复制出来的节点.
            list.next = list.next.next; //将list更新.
            temp.next = null;  //复制出来的节点新不指向任何地址.就是从原链中脱离出来.
            list = list.next;  // 相当于更新list,此时的list.next已经是下一个不重复的节点.
            if (newList == null){
                newList = temp;  //新链的末端节点,因为开始开始空,所以直接把头让给它.
                res = temp;  //将头结点确定.
            }else {
                newList.next = temp;  //这边开始将新链延长.毕竟已经有头节点啦.
                newList = newList.next;  //更新新链末端节点
            }

        }
        return res;
    }
}