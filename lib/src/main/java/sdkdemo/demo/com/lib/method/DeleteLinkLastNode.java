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

        System.out.println("node : " + testRevert3(head));
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
        if (head == null || head.next == null) {
            return head;
        }
        ListNode next     = head.next;
        ListNode head_new = revertNode(next);
        next.next = head;
        head.next = null;

        return head_new;
    }

    private ListNode revertNode2(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode pre = head;
        ListNode cur = head.next;
        ListNode temp;
        while (cur != null) {
            temp = cur.next;
            cur.next = pre;

            pre = cur;
            cur = temp;
        }

        head.next = null;

        return pre;
    }

    private ListNode testRevert1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode next     = head.next;
        ListNode new_head = testRevert1(next);

        next.next = head;
        head.next = null;
        return new_head;
    }

    private ListNode testRevert3(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }

       ListNode pre = head;
        ListNode cur = head.next;
        while (cur != null){
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        head.next = null;
        return pre;
    }

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
