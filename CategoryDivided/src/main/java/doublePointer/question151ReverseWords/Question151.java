 package doublePointer.question151ReverseWords;

 import java.util.concurrent.locks.ReentrantLock;

 /**
 * @Author puka
 * @Description 反转字符串中的单词
 * @Date 2023/7/11 14:24
 */
public class Question151 {
    public static void main(String[] args) {
        String s = " the sky is blue";
        System.out.println(new Solution().removeSpace(s));
    }
}

class Solution {
//    public String reverseWords(String s) {
//        //这里采用双指针的方法来完成
//        Integer fast = 0, slow = 0;
//
//
//    }

    public String removeSpace(String s) {
        // System.out.println("ReverseWords.removeSpace() called with: s = [" + s + "]");
        int start = 0;
        int end = s.length() - 1;
        while (s.charAt(start) == ' ') start++;
        while (s.charAt(end) == ' ') end--;
        StringBuilder sb = new StringBuilder();
        while (start <= end) {
            char c = s.charAt(start);
            if (c != ' ' || sb.charAt(sb.length() - 1) != ' ') {
                sb.append(c);
            }
            start++;
        }
        // System.out.println("ReverseWords.removeSpace returned: sb = [" + sb + "]");
        return sb.toString();
    }
}