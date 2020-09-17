package sdkdemo.demo.com.lib.method;

/**
 * Created by  sjx  on 2020/9/14
 */
public class DeleteLinkLastNode {
    public void solution(){
        ListNode head = new ListNode("1");
        ListNode twoNode = new ListNode("2");
        ListNode threeNode = new ListNode("3");
        ListNode fourNode = new ListNode("4");
        ListNode fiveNode = new ListNode("5");

        head.setNext(twoNode);
        twoNode.setNext(threeNode);
        threeNode.setNext(fourNode);
        fourNode.setNext(fiveNode);

        ListNode node = removeNthFromEnd(head, 2);
        System.out.println("node : " + node.toString());
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        int index = 0;
        ListNode tempNode = head;
        while (tempNode.next != null){
            tempNode = tempNode.next;
            index ++;
        }

        System.out.println("index : " + index);
        return head;
    }

    private class ListNode {
        private String content;
        ListNode next;

        public ListNode(String content) {
            this.content = content;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public ListNode getNext() {
            return next;
        }

        public void setNext(ListNode next) {
            this.next = next;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "content='" + content + '\'' +
                    ", next=" + next +
                    '}';
        }
    }
}
