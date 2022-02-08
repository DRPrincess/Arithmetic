import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 请实现 copyRandomList 函数，复制一个复杂链表。在复杂链表中，每个节点除了有一个 next 指针指向下一个节点，还有一个 random 指针指向链表中的任意节点或者 null。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/fu-za-lian-biao-de-fu-zhi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author duanrui
 */
public class SwordOffer35 {

    public static void main(String[] args) {
        int[][] data = new int[][]{{7, -1}, {13, 0}, {11, 4}, {10, 2}, {1, 0}};
        List<Node> list = new ArrayList<>();
        for (int i = 0; i < data.length; i++) {
            Node current = new Node(data[i][0]);
            list.add(current);
        }
        for (int i = 0; i < data.length; i++) {
            int rom = data[i][1];
            if (i < data.length - 1) {
                list.get(i).next = list.get(i + 1);
            }
            if (rom != -1) {
                list.get(i).random = list.get(rom);
            }
        }

        Node head = list.get(0);
        print(head);
        System.out.println("----------------------------------");
        Node copyHead = new Solution01().copyRandomList(head);
        print(copyHead);
        System.out.println("----------------------------------");
        head.val = 9999;
        System.out.println("head:" + head.val);
        System.out.println("copyHead:" + copyHead.val);

    }

    private static void print(Node head) {
        if(head == null){
            System.out.println("[]");
        }
        while (head.next != null) {
            System.out.println(head);
            head = head.next;
        }
        System.out.println(head);
    }

    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }

        @Override
        public String toString() {
            return "[" +
                    val + "," + random +
                    ']';
        }
    }

    /**
     * 自己的解法
     * 时间复杂度 O(N^2),实际上 N^2+2*N 主要是因为错误用了列表的 IndexOf,内部也是for,导致N^2
     * 空间复杂度 O(N) 实际上 2*N
     */
    static class Solution {
        public Node copyRandomList(Node head) {
            if (head == null) {
                return null;
            }

            List<Node> nodeList = new ArrayList<>();
            while (head != null) {
                nodeList.add(head);
                head = head.next;
            }
            List<Node> copyNodeList = new ArrayList<>();
            for (int i = 0; i < nodeList.size(); i++) {
                Node node = new Node(nodeList.get(i).val);
                copyNodeList.add(node);
                if (i > 0) {
                    copyNodeList.get(i - 1).next = node;
                }
            }
            for (int i = 0; i < nodeList.size(); i++) {
                Node randomNode = nodeList.get(i).random;
                if (randomNode != null) {
                    copyNodeList.get(i).random = copyNodeList.get(nodeList.indexOf(randomNode));
                }
            }
            return copyNodeList.get(0);
        }
    }
    /**
     * 题解解法
     * 时间复杂度 O(N),实际上 2*N
     * 空间复杂度 O(N) 实际上 N+1
     */
    static class Solution01 {
        public Node copyRandomList(Node head) {
            if (head == null) {
                return null;
            }
            Map<Node,Node> dic = new HashMap<>();
            Node cur = head;
            while (cur != null){
                dic.put(cur,new Node(cur.val));
                cur = cur.next;
            }
            cur = head;
            while (cur != null){
                dic.get(cur).next =dic.get(cur.next);
                dic.get(cur).random =dic.get(cur.random);
                cur = cur.next;
            }
            return dic.get(head);
        }
    }
}
