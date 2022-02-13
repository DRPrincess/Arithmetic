/**
 * 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。请定义一个函数实现字符串左旋转操作的功能。比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。
 *
 *  
 *
 * 示例 1：
 *
 * 输入: s = "abcdefg", k = 2
 * 输出: "cdefgab"
 * 示例 2：
 *
 * 输入: s = "lrloseumgh", k = 6
 * 输出: "umghlrlose"
 *  
 *
 * 限制：
 *
 * 1 <= k < s.length <= 10000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zuo-xuan-zhuan-zi-fu-chuan-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SwordOffer58 {

    public static void main(String[] args) {
        String s = "abcdefg";
        System.out.println(new SwordOffer58.Solution().reverseLeftWords("abcdefg",2));
        System.out.println("----------------------------------");
        System.out.println(new SwordOffer58.Solution().reverseLeftWords("lrloseumgh",6));

    }

    /**
     * 空间复杂度: O(N)
     * 时间复杂度: O(N)
     * 执行用时：
     * 3 ms
     * , 在所有 Java 提交中击败了
     * 43.96%
     * 的用户
     * 内存消耗：
     * 41 MB
     * , 在所有 Java 提交中击败了
     * 11.71%
     * 的用户
     */
    static class Solution {
        public String reverseLeftWords(String s, int n) {
            char[] charArray =new  char[s.length()];
            int j = 0;
            int k = s.length()-n;
            for (int i = 0; i <s.length() ; i++) {
                if(i<n){
                    charArray[k++] = s.charAt(i);
                }else{
                    charArray[j++] =s.charAt(i);
                }
            }
            return new String(charArray);


        }
    }
    /**
     * 空间复杂度: O(N)
     * 时间复杂度: O(N)
     */
    static class Solution1 {
        public String reverseLeftWords(String s, int n) {
            char[] charArray =new  char[s.length()];
            int j = 0;
            int k = s.length()-n;
            for (int i = 0; i <n ; i++) {
                charArray[k++] = s.charAt(i);
            }
            return new String(charArray);


        }
    }
}
