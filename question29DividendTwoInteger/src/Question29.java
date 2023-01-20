public class Question29 {
    public static void main(String[] args) {
        int dividend = -2147483648;
        int divisor = 2;
        Solution out = new Solution();
        System.out.println(out.divide(dividend, divisor));
    }
}

/**
 * question
 * 给你两个整数，被除数 dividend 和除数 divisor。将两数相除，要求 不使用 乘法、除法和取余运算。
 *
 * 整数除法应该向零截断，也就是截去（truncate）其小数部分。例如，8.345 将被截断为 8 ，-2.7335 将被截断至 -2 。
 *
 * 返回被除数 dividend 除以除数 divisor 得到的 商 。
 *
 * 注意：假设我们的环境只能存储 32 位 有符号整数，其数值范围是 [−231,  231 − 1] 。本题中，如果商 严格大于 231 − 1 ，则返回 231 − 1 ；如果商 严格小于 -231 ，则返回 -231 。
 */

class Solution {

    //反思：需要考虑到边界的问题，但主要是注意到负数的最小值比整数最大值范围要大，所以建议用负数来表示
    public int divide(int dividend, int divisor) {
        if(dividend == 0) return 0;
        if(divisor == 1) return dividend;
        if(divisor == -1){
            if(dividend>Integer.MIN_VALUE) return -dividend;// 只要不是最小的那个整数，都是直接返回相反数就好啦
            return Integer.MAX_VALUE;// 是最小的那个，那就返回最大的整数啦
        }
        int flag = 1;//表示答案的符号
        int out = 0;//表示结果
        if (dividend > 0){
            flag = -flag;
            dividend = -dividend;
        }
        if (divisor > 0){
            flag = -flag;
            divisor = -divisor;
        }

        while(dividend <= divisor){
            out++;
            dividend -= divisor;
        }

        if (flag<0){
            return -out;
        }
        return out;
    }
}
