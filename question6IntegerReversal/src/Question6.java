public class Question6 {
    public static void main(String[] args) {
        Integer data = 2147483412;
        //2143847412
        Solution out = new Solution();
        System.out.println(out.reverse3(data));
    }
}
/**
 * question
 * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
 *
 * 如果反转后整数超过 32 位的有符号整数的范围 [−231,  231 − 1] ，就返回 0。
 *
 * 假设环境不允许存储 64 位整数（有符号或无符号）。
 */
class Solution {
    //运用字符串的方式完成
    public int reverse(int x) {
        int out = 0;
        if(x == 0) return x;
        int flag = 1;
        if(x < 0){
            flag = -1;
            x = -x;
        }
        String data = String.valueOf(x);
        StringBuilder outStr = new StringBuilder();
        for (int i = 0; i < data.length(); i++) {
            outStr.append(data.charAt(data.length()-i-1));
        }
        try{
            return Integer.valueOf(outStr.toString())*flag;
        }
        catch (NumberFormatException e){
            return 0;
        }
    }

    //运用StringBuilder的reverse
    public int reverse2(int x) {
        int out = 0;
        if(x == 0) return x;
        int flag = 1;
        if(x < 0){
            flag = -1;
            x = -x;
        }
        StringBuilder outStr = new StringBuilder(String.valueOf(x));
        System.out.println(outStr);
        outStr.reverse();
        try{
            return Integer.valueOf(outStr.toString())*flag;
        }
        catch (NumberFormatException e){
            return 0;
        }
    }

    //通过计算的方式来获取 很完美，内存消耗击败99.87%
    public int reverse3(int x) {
        int out = 0;
        int maxValue = Integer.MAX_VALUE;
        System.out.println(maxValue);
        if(x == 0) return x;
        int flag = 1;
        if(x < 0){
            flag = -1;
            x = -x;
        }
        while (x > 0){
            if (out > maxValue/10 || (out == maxValue/10 && x > maxValue%10)){
                return 0;
            }
            out = out * 10 + x % 10;
            x /= 10;
        }
        return out*flag;
    }
}