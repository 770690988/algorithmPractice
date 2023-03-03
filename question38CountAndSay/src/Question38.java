public class Question38 {
    public static void main(String[] args) {
        int n = 5;
        Solution out = new Solution();
        System.out.println(out.countAndSay(n));
    }
}

/**
 * question
 * 「外观数列」是一个整数序列，从数字 1 开始，序列中的每一项都是对前一项的描述。
 * 你可以将其视作是由递归公式定义的数字字符串序列：
 * countAndSay(1) = "1"
 * countAndSay(n) 是对 countAndSay(n-1) 的描述，然后转换成另一个数字字符串。
 */

class Solution {
    public String countAndSay(int n) {
        StringBuilder data = new StringBuilder("1");
        if(n == 1){
            return data.toString();
        }
        for (int i = 1; i < n; i++) {
            int length = data.length();
            char charIndex = data.charAt(0);
            int charNum = 1;
            StringBuilder str = new StringBuilder();
            for (int j = 1; j < length; j++) {
                if (charIndex != data.charAt(j)){
                    //说明需要计算添加
                    str.append(charNum);
                    str.append(charIndex);
                    charIndex = data.charAt(j);
                    charNum = 1;
                }else {
                    //说明继续往后
                    charNum++;
                }
            }
            str.append(charNum);
            str.append(charIndex);
            data = str;
        }
        return data.toString();
    }
}
