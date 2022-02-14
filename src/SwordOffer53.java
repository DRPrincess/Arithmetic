/**
 * 统计一个数字在排序数组中出现的次数。
 * 示例 1:
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: 2
 * <p>
 * 示例 2:
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: 0
 *  
 * <p>
 * 提示：
 * 0 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 * nums 是一个非递减数组
 * -109 <= target <= 109
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zai-pai-xu-shu-zu-zhong-cha-zhao-shu-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class SwordOffer53 {

    public static void main(String[] args) {
        System.out.println(new SwordOffer53.Solution().search(new int[]{5,7,7,8,8,10}, 8));
        System.out.println("----------------------------------");
        System.out.println(new SwordOffer53.Solution1().search(new int[]{5,7,7,8,8,10}, 8));
        System.out.println("----------------------------------");
        System.out.println(new SwordOffer53.Solution2().search(new int[]{5,7,7,8,8,10}, 8));
    }

    /**
     * 重点：
     * 1.统计一个数字在《排序数组》中出现的次数。
     * 2.nums 是一个非递减数组
     * 结论：
     * 这是一个升序数组
     */

    /**
     * 时间复杂度 O(N)
     * 空间复杂度 O(1)
     *
     * 88 / 88 个通过测试用例
     * 状态：通过
     * 执行用时: 1 ms
     * 内存消耗: 44.1 MB
     */
    static class Solution {
        public int search(int[] nums, int target) {
            int count = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == target) {
                    count++;
                }
            }
            return count;
        }
    }
    /**
     *
     * 二分法
     *
     * 时间复杂度 O(Log2N)
     * 空间复杂度 O(1)
     *
     * 执行用时: 0 ms
     * 内存消耗: 44.3 MB
     */
    static class Solution1 {
        public int search(int[] nums, int target) {
            if(nums.length == 0){
                return 0;
            }
            int i = 0;
            int j = nums.length-1;

            // 搜索右边界 right
            while (i<=j){
                int mid = (i+j)/2;
                //优先找右边
                if (nums[mid] <= target) {
                    i = mid+1;
                }else{
                    j = mid-1;
                }
            }
            int right = i;
            // 若数组中无 target ，则提前返回
            /**
             *  这句话的必要性
             *  先从左往右找，原始状态 i<j
             *  结束状态 j<=i,num[j]一定不可能大于target
             *  而且，按照二分法，两者状态一定 j+1 = i,两者相邻1位
             *
             *  证明：
             *  如果j == target，左边还有重复的值
             *  如果j < target，左边一定没有target
             */
            if(j >= 0 && nums[j] != target){
                return 0;
            }
            i= 0; j = nums.length - 1;
            // 搜索左边界
            while (i<=j){
                int mid = (i+j)/2;
                if (nums[mid] < target) {
                    i = mid+1;
                }else{
                    j = mid-1;
                }
            }

            int left = j;
            return right - left - 1;
        }
    }


    static class Solution2 {
        public int findRight(int[] nums, int target){
            int i= 0;
            int j = nums.length - 1;
            // 搜索右边界 right
            while (i<=j){
                int mid = (i+j)/2;
                //优先找右边
                if (nums[mid] <= target) {
                    i = mid+1;
                }else{
                    j = mid-1;
                }
            }
            return i;
        }
        public int search(int[] nums, int target) {
            if(nums.length == 0){
                return 0;
            }
            return findRight(nums,target) - findRight(nums,target-1);
        }
    }

}
