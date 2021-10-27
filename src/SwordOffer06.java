import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

/**
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：head = [1,3,2]
 * 输出：[2,3,1]
 *  
 * <p>
 * 限制：
 * <p>
 * 0 <= 链表长度 <= 10000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SwordOffer06 {

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
        System.out.println(Arrays.toString( new Solution().reversePrint(head)));
        System.out.println(Arrays.toString( new Solution1().reversePrint(head)));
    }
}


class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

/**
 * 辅助栈
 * 时间复杂度O(n)
 * 空间复杂度O(n)
 */
class Solution {
    Stack<ListNode> stack = new Stack<>();

    public int[] reversePrint(ListNode head) {
        ListNode tempNode = head;
        while (tempNode != null) {
            stack.push(tempNode);
            tempNode = tempNode.next;
        }
        int size = stack.size();
        int[] print = new int[size];
        for (int i = 0; i < size; i++) {
            print[i] = stack.pop().val;
        }
        return print;

    }
}

/**
 * 递归
 * 时间复杂度O(n)
 * 空间复杂度O(n)
 */
class Solution1 {
    ArrayList<Integer> tmp = new ArrayList<>();

    public int[] reversePrint(ListNode head) {
        recur(head);
        int[] res = new int[tmp.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = tmp.get(i);

        }
        return res;
    }

    void recur(ListNode head) {
        if (head == null) {
            return;
        }
        recur(head.next);
        tmp.add(head.val);
    }

}
