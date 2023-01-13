public class Question7 {
    public static void main(String[] args) {
        String data = " ";
        Solution out = new Solution();
        System.out.println(out.myAtoi(data));
    }
}

/**
 * 请你来实现一个 myAtoi(string s) 函数，使其能将字符串转换成一个 32 位有符号整数（类似 C/C++ 中的 atoi 函数）。
 *
 * 函数 myAtoi(string s) 的算法如下：
 *
 * 读入字符串并丢弃无用的前导空格
 * 检查下一个字符（假设还未到字符末尾）为正还是负号，读取该字符（如果有）。 确定最终结果是负数还是正数。 如果两者都不存在，则假定结果为正。
 * 读入下一个字符，直到到达下一个非数字字符或到达输入的结尾。字符串的其余部分将被忽略。
 * 将前面步骤读入的这些数字转换为整数（即，"123" -> 123， "0032" -> 32）。如果没有读入数字，则整数为 0 。必要时更改符号（从步骤 2 开始）。
 * 如果整数数超过 32 位有符号整数范围 [−231,  231 − 1] ，需要截断这个整数，使其保持在这个范围内。具体来说，小于 −231 的整数应该被固定为 −231 ，大于 231 − 1 的整数应该被固定为 231 − 1 。
 * 返回整数作为最终结果。
 */

class Solution {
    public int myAtoi(String s) {
        int startPosition = 0;
        int endPosition = s.length();
        int flag = 0;
        for (int i = 0; i < s.length(); i++) {
            if ((s.charAt(i) <= '9' && s.charAt(i) >= '0')){
                startPosition = i;
                break;
            }else if (s.charAt(i) == '-') {
                flag = -1;
                startPosition = i;
                break;
            }else if (s.charAt(i) == '+'){
                flag = 1;
                startPosition = i;
                break;
            }else if (s.charAt(i) != ' '){
                return 0;
            }
        }
        for (int i = startPosition+1; i < s.length(); i++) {
            if (s.charAt(i) > '9' || s.charAt(i) < '0'){
                endPosition = i;
                break;
            }
        }
        String outString;
        if (endPosition != 0){
            outString = s.substring(startPosition, endPosition);
        }else {
            outString = s.substring(startPosition);
        }
        System.out.println("outString is:"+outString);
        if (outString.isEmpty()) return 0;
        if (startPosition == endPosition-1 && (s.charAt(startPosition) == '-' || s.charAt(startPosition) == '+')){
            return 0;
        }
        try{
            return Integer.valueOf(outString);
        }
        catch (Exception e){
            if (outString.charAt(0) == '-'){
                return Integer.MIN_VALUE;
            }else{
                return Integer.MAX_VALUE;
            }
        }

    }
}