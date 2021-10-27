import java.util.Stack;

/**
 * 功能： 剑指 Offer 09. 用两个栈实现队列
 * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )
 *
 *  
 *
 * 示例 1：
 *
 * 输入：
 * ["CQueue","appendTail","deleteHead","deleteHead"]
 * [[],[3],[],[]]
 * 输出：[null,null,3,-1]
 * 示例 2：
 *
 * 输入：
 * ["CQueue","deleteHead","appendTail","appendTail","deleteHead","deleteHead"]
 * [[],[],[5],[2],[],[]]
 * 输出：[null,-1,null,null,5,2]
 * 提示：
 *
 * 1 <= values <= 10000
 * 最多会对 appendTail、deleteHead 进行 10000 次调用
 *
 */
public class SwordOffer09 {

    public static void main(String[] args) {
        CQueue09 cQueue = new CQueue09();
        cQueue.deleteHead();
        cQueue.appendTail(5);
        cQueue.appendTail(2);
        cQueue.deleteHead();
        cQueue.deleteHead();

        System.out.println("-------");
        cQueue.deleteHead01();
        cQueue.appendTail01(5);
        cQueue.appendTail01(2);
        cQueue.deleteHead01();
        cQueue.appendTail01(8);
        cQueue.deleteHead01();


    }
}

class CQueue09 {
    private final Stack<Integer> originStack;
    private final Stack<Integer> deleteStack;

    public CQueue09() {
        originStack = new Stack();
        deleteStack = new Stack();

    }

    public void appendTail(int value) {
        while (!deleteStack.isEmpty()) {
            originStack.push(deleteStack.pop());
        }
        originStack.push(value);
        while (!originStack.isEmpty()) {
            deleteStack.push(originStack.pop());
        }
        System.out.println("null");
    }

    public int deleteHead() {
        if (deleteStack.isEmpty()) {
            return -1;
        }
        int result = deleteStack.pop();
        System.out.println(result);
        return result;
    }

    public void appendTail01(int value) {
        originStack.push(value);
        System.out.println("null");
    }

    public int deleteHead01() {
        if (deleteStack.isEmpty()) {
            while (!originStack.isEmpty()) {
                deleteStack.push(originStack.pop());
            }
        }
        if (deleteStack.isEmpty()) {
            return -1;
        }
        int result = deleteStack.pop();
        System.out.println(result);
        return result;
    }
}
