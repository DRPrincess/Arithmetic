/**
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 * 示例 1：
 * 输入：s = "We are happy."
 * 输出："We%20are%20happy."
 * 限制：
 * 0 <= s 的长度 <= 10000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ti-huan-kong-ge-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 *
 *
 * C++ 语言的可以做到 时间复杂度O(N),空间复杂度O(1) 原因在于C++ 支持可变字符串，无需定义新的数组，直接在原字符串进行修改。
 * java 语言 只能做到 时间复杂度O(N),空间复杂度O(N)，原因在于字符串的不可变性，必须要生成新的字符串
 */
public class SwordOffer05 {

    public static void main(String[] args) {
        String s = "We are happy.";
        System.out.println(new Solution().replaceSpace(s));
        System.out.println("----------------------------------");
        System.out.println(new Solution1().replaceSpace(s));
        System.out.println("----------------------------------");
        System.out.println(new Solution2().replaceSpace(s));
    }

    /**
     * 用的是官方api 无法分析复杂度
     */
    static class Solution {
        public String replaceSpace(String s) {
            //return s.replace(" ", "%20");
            return s.replaceAll(" ", "%20");

        }
    }

    /**
     * 时间复杂度 O(N)
     * 空间复杂度 O(N)
     */
    static class Solution1 {
        public String replaceSpace(String s) {
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                var c = s.charAt(i);
                if (s.charAt(i) != ' ') {
                    builder.append(c);
                } else {
                    builder.append("%20");
                }

            }

            return builder.toString();

        }
    }
    /**
     * 时间复杂度 O(N)
     * 空间复杂度 O(N)
     * StringBuilder追加的数据的个数超过了数组的大小的时候，需要对 char 类型的数据进行扩容，
     * 扩容有性能损耗，
     * 这个方法使用，算出可用的固定长度，静态数组，减少性能损耗
     */
    static class Solution2 {
        public String replaceSpace(String s) {
            int diff = "%20".length() - " ".length();
            int count = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == ' ') {
                    count++;
                }
            }
            char[] newArr = new char[diff * count + s.length()];
            int j = 0;
            for (int i = 0; i < s.length(); i++) {
                var c = s.charAt(i);
                if (c == ' ') {
                    newArr[j++] = '%';
                    newArr[j++] = '2';
                    newArr[j++] = '0';
                }else{
                    newArr[j++] = c;
                }
            }
            return new String(newArr,0,j);
        }
    }
}


