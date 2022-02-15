/**
 * 剑指 Offer 04. 二维数组中的查找
 * 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个高效的函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * <p>
 *  
 * <p>
 * 示例:
 * <p>
 * 现有矩阵 matrix 如下：
 * <p>
 * [
 * [1,   4,  7, 11, 15],
 * [2,   5,  8, 12, 19],
 * [3,   6,  9, 16, 22],
 * [10, 13, 14, 17, 24],
 * [18, 21, 23, 26, 30]
 * ]
 * 给定 target = 5，返回 true。
 * <p>
 * 给定 target = 20，返回 false。
 * <p>
 *  
 * <p>
 * 限制：
 * <p>
 * 0 <= n <= 1000
 * <p>
 * 0 <= m <= 1000
 * <p>
 * 作者：Krahets
 * 链接：https://leetcode-cn.com/leetbook/read/illustration-of-algorithm/5v76yi/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class SwordOffer04 {

    public static void main(String[] args) {
        // int[][] matrix = {{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}};
        int[][] matrix = {};
        System.out.println(new SwordOffer04.Solution().findNumberIn2DArray(matrix, 5));
        System.out.println("----------------------------------");
    }

    /**
     * 关键字：
     * n * m 的二维数组中
     * 每一行都按照从左到右递增的顺序排序，
     * 每一列都按照从上到下递增的顺序排序。
     *
     * 图的数据结构
     * 进行翻转
     * “根节点” 对应的是矩阵的 “左下角” 和 “右上角” 元素，本文称之为 标志数 ，以 matrix 中的 左下角元素 为标志数 flag ，则有:
     *
     * 若 flag > target ，则 target 一定在 flag 所在 行的上方 ，即 flag 所在行可被消去。
     * 若 flag < target ，则 target 一定在 flag 所在 列的右方 ，即 flag 所在列可被消去。
     *
     * 作者：Krahets
     * 链接：https://leetcode-cn.com/leetbook/read/illustration-of-algorithm/5vl81e/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     */

    /**
     *
     * 时间复杂度 O(M+N)
     * 空间复杂度 O(1)
     * <p>
     * 注意点：防止空数组输入，例如{},{{}} 等
     * <p>
     * 129 / 129 个通过测试用例
     * 状态：通过
     * 执行用时: 0 ms
     * 内存消耗: 47.4 MB
     */
    static class Solution {
        public boolean findNumberIn2DArray(int[][] matrix, int target) {

            //行数
            int n = matrix.length;
            if (n == 0) {
                return false;
            }
            //列数
            int m = matrix[0].length;
            int i = n - 1;
            int j = 0;
            while (i >= 0 && j < m) {
                if (matrix[i][j] == target) {
                    return true;
                }
                if (matrix[i][j] < target) {
                    j++;
                } else {
                    i--;
                }
            }
            return false;
        }

    }

}
