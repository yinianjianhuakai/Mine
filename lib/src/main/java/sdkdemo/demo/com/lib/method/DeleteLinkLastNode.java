package sdkdemo.demo.com.lib.method;

/**
 * Created by  sjx  on 2020/9/14
 */
public class DeleteLinkLastNode {
    public void solution() {
        ListNode head      = new ListNode(1);
        ListNode twoNode   = new ListNode(2);
        ListNode threeNode = new ListNode(3);
        ListNode fourNode  = new ListNode(4);
        ListNode fiveNode  = new ListNode(5);

        head.next = twoNode;
        twoNode.next = threeNode;
        threeNode.next = fourNode;
        fourNode.next = fiveNode;

//        ListNode node = removeNthFromEnd(head, 2);
//        System.out.println("node : " + node.toString());

        System.out.println("node : " + revertNode(head));
    }

    //移除单链表的倒数第n个
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        int      index    = 0;
        ListNode tempNode = head;
        while (tempNode.next != null) {
            tempNode = tempNode.next;
            index++;
        }

        int      length    = index - n;
        ListNode firstNode = dummy;
        while (length >= 0) {
            length--;
            firstNode = firstNode.next;
        }
        firstNode.next = firstNode.next.next;

        System.out.println("index : " + index);
        return dummy.next;
    }

    //反转
    private ListNode revertNode(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode next = head.next;
        ListNode head_new = revertNode(next);
        next.next = head;
        head.next = null;

        return head_new;
    }

//    private ListNode revertNode(ListNode head) {
//        ListNode dummy = new ListNode(0);
//
//        ListNode first = head;
//        while (first.next != null) {
//            first = first.next;
//        }
//
//        return dummy.next = first;
//
//    }

    private class ListNode {
        int      val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }
}