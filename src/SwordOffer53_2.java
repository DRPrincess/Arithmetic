/**
 * 剑指 Offer 53 - II. 0～n-1中缺失的数字
 *
 * 一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
 * 示例 1:
 * 输入: [0,1,3]
 * 输出: 2
 * 示例 2:
 *
 * 输入: [0,1,2,3,4,5,6,7,9]
 * 输出: 8
 *  
 *
 * 限制：
 *
 * 1 <= 数组长度 <= 10000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/que-shi-de-shu-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SwordOffer53_2 {
    public static void main(String[] args) {
        System.out.println(new SwordOffer53_2.Solution().missingNumber(new int[]{0,1,2,3,4,5,6,7,9}));
        System.out.println("----------------------------------");
    }

    /**
     * 关键字：
     * 「长度为n-1」
     * 「递增排序数组」
     * 「每个数字都在范围0～n-1」
     *
     *  推测结论：不等差数列，常规差是1，非常规差是2，需要找出常规差为2的范围
     *
     *  正确答案矫正思路：二分法
     *  左子数组： nums[i] =i ；
     *  右子数组： nums[i] != i
     *  缺失的数字等于 “右子数组的首位元素” 对应的索引
     *
     *  找出右数组的首位
     * ​
     *
     *
     *  执行用时：0 ms
     *  内存消耗：41.9 MB
     */
    static class Solution {
        public int missingNumber(int[] nums) {
            int i = 0;
            int j = nums.length -1;
            while (i<=j){
                int mid =  (i+j)/2;
                if(nums[mid]==mid){
                    i = mid+1;
                }else {
                    j = mid-1;
                }
            }
            return i;
        }
    }
}
