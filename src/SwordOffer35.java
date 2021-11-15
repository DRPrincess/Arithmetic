/**
 * 请实现 copyRandomList 函数，复制一个复杂链表。在复杂链表中，每个节点除了有一个 next 指针指向下一个节点，还有一个 random 指针指向链表中的任意节点或者 null。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/fu-za-lian-biao-de-fu-zhi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author duanrui
 */
public class SwordOffer35 {

    public static void main(String[] args) {
        ListNode head = null;
        ListNode temp = null;
        int[] data = new int[]{3,3,3};
                new int[][]{{3,null,[3,0],[3,null]};
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
        head = [[3,null],[3,0],[3,null]]

        new Solution().copyRandomList(head);
    }

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    static class Solution {
        public Node copyRandomList(Node head) {

            return head;
        }
    }
}
