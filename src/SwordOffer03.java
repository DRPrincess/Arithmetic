import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * 找出数组中重复的数字。
 * <p>
 * <p>
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
 * <p>
 * 示例 1：
 * <p>
 * 输入：
 * [2, 3, 1, 0, 2, 5, 3]
 * 输出：2 或 3
 *  
 * <p>
 * 限制：
 * <p>
 * 2 <= n <= 100000
 * <p>
 * 作者：Krahets
 * 链接：https://leetcode-cn.com/leetbook/read/illustration-of-algorithm/59bjss/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class SwordOffer03 {

    public static void main(String[] args) {
        System.out.println(new SwordOffer03.Solution().findRepeatNumber(new int[]{2, 3, 1, 0, 2, 5, 3}));
        System.out.println("----------------------------------");
        System.out.println(new SwordOffer03.Solution1().findRepeatNumber(new int[]{2, 3, 1, 0, 2, 5, 3}));
        System.out.println("----------------------------------");
        System.out.println(new SwordOffer03.Solution2().findRepeatNumber(new int[]{2, 3, 1, 0, 2, 5, 3}));
        System.out.println("----------------------------------");
        System.out.println(new SwordOffer03.Solution3().findRepeatNumber(new int[]{2, 3, 1, 0, 2, 5, 3}));
        System.out.println("----------------------------------");
        System.out.println(new SwordOffer03.Solution4().findRepeatNumber(new int[]{2, 3, 1, 0, 2, 5, 3}));
    }

    /**
     * 时间复杂度 O(N)
     * 空间复杂度 O(N)
     * 但是HashMap 的 value 无意义
     * <p>
     * 25 / 25 个通过测试用例
     * 状态：通过
     * 执行用时: 7 ms
     * 内存消耗: 50 MB
     */
    static class Solution {
        public int findRepeatNumber(int[] nums) {
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                if (map.containsKey(nums[i])) {
                    return nums[i];
                } else {
                    map.put(nums[i], nums[i]);
                }
            }

            return -1;
        }
    }

    /**
     * 和上个方法没有本质上的的区别，就是Set比Map用的优雅了一点
     * 时间复杂度 O(N)
     * 空间复杂度 O(N)
     * <p>
     * 25 / 25 个通过测试用例
     * 状态：通过
     * 执行用时: 7 ms
     * 内存消耗: 49.7 MB
     */
    static class Solution1 {
        public int findRepeatNumber(int[] nums) {
            Set<Integer> set = new HashSet<>();
            for (int i = 0; i < nums.length; i++) {
                if (set.contains(nums[i])) {
                    return nums[i];
                } else {
                    set.add(nums[i]);
                }
            }

            return -1;
        }
    }


    /**
     * 性能会好一点，数组代替hash,查找效率会更快
     * <p>
     * 时间复杂度 O(N)
     * 空间复杂度 O(N)
     * <p>
     * 25 / 25 个通过测试用例
     * 状态：通过
     * 执行用时: 2 ms
     * 内存消耗: 48.3 MB
     */
    static class Solution2 {
        public int findRepeatNumber(int[] nums) {
            int[] bucket = new int[nums.length];
            Arrays.fill(bucket, -1);
            for (int i = 0; i < nums.length; i++) {
                //当前的值，是否在出现过
                if (bucket[nums[i]] != -1) {
                    return nums[i];
                } else {
                    //没有出现就存储一下，
                    //存储的值其实不重要，只要不是初始值-1就可以
                    //这里用i,可以记录一下重复的位置
                    bucket[nums[i]] = i;
                }
            }
            return -1;
        }
    }

    /**
     * 使用排序方法，原地交换的思路
     * 时间复杂度 O(N)
     * 空间复杂度是 O(1)
     * <p>
     * 25 / 25 个通过测试用例
     * 状态：通过
     * 执行用时: 0 ms
     * 内存消耗: 48.7 MB
     */
    static class Solution3 {
        public int findRepeatNumber(int[] nums) {
            for (int i = 0; i < nums.length; i++) {
                //索引和值不一样
                while (nums[i] != i) {
                    if (nums[i] == nums[nums[i]]) {
                        return nums[i];
                    }
                    int tmp = nums[nums[i]];
                    nums[nums[i]] = nums[i];
                    nums[i] = tmp;
                }

            }
            return -1;
        }
    }

    /**
     * 和原地交换是一个思路，只不过写法不一样
     */
    static class Solution4 {
        public int findRepeatNumber(int[] nums) {
            int i = 0;
            while (i < nums.length) {
                if (nums[i] == i) {
                    i++;
                    continue;
                }
                if (nums[nums[i]] == nums[i]) {
                    return nums[i];
                }
                int tmp = nums[i];
                nums[i] = nums[tmp];
                nums[tmp] = tmp;
            }
            return -1;
        }

    }
}
