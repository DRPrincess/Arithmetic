/**
 * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 * <p>
 *  
 * <p>
 * 示例:
 * <p>
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 *  
 * <p>
 * 限制：
 * <p>
 * 0 <= 节点个数 <= 5000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/fan-zhuan-lian-biao-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SwordOffer24 {

    public static void main(String[] args) {
        ListNode head = null;
        ListNode temp = null;
        int[] data = new int[]{1, 3, 2};
        for (int i = 0; i < data.length; i++) {
            ListNode current = new ListNode(data[i]);
            if (temp != null && temp.next == null) {
                temp.next = current;
            }
            temp = current;
            if (head == null) {
                head = temp;
            }
        }
//        ListNode newHead = new SwordOffer24Solution().reversePrint(head);
        ListNode newHead = new SwordOffer24Solution1().reversePrint(head);

        ListNode tempNode = newHead;
        while (tempNode != null) {
            System.out.println(tempNode.val);
            tempNode = tempNode.next;
        }
    }

    /**
     * 辅助栈
     * 时间复杂度O(n)
     */
    static class SwordOffer24Solution {

        public ListNode reversePrint(ListNode head) {
            ListNode tempNode = head;
            ListNode newHead = null;
            while (tempNode != null) {
                ListNode next = tempNode.next;
                tempNode.next = newHead;
                newHead = tempNode;
                tempNode = next;
            }
            return newHead;
        }
    }

    static class SwordOffer24Solution1 {
        public ListNode reversePrint(ListNode head) {
            if(head == null || head.next == null){
               return head;
            }
            ListNode newHead = reversePrint(head.next);
            head.next.next = head;
            head.next = null;
            return newHead;
        }

        private ListNode recer(ListNode node, ListNode newHead) {
            if(node == null || node.next == null){
                newHead = node;
            }else{
                ListNode next = recer(node.next,newHead);
                next.next = node;
            }
            return node.next;
        }
    }
}






