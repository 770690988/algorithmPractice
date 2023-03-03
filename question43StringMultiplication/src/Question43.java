public class Question43 {
    public static void main(String[] args) {
        String num1 = "0";
        String num2 = "0";
        System.out.println(new Solution().multiply(num1,num2));
    }
}

class Solution{
    public String multiply(String num1, String num2) {
        StringBuilder outBuilder = new StringBuilder();
        Integer length1 = num1.length();
        Integer length2 = num2.length();
        Integer[] op = new Integer[200];
        for (int i = 0; i < 200; i++) {
            op[i] = 0;
        }
        for (int i = 0; i < length2; i++) {
            Integer char2 = num2.charAt(length2-1-i) - '0';
            for (int j = 0; j < length1; j++) {
                Integer char1 = num1.charAt(length1-1-j) - '0';
                Integer comeout  = char1*char2;
//                System.out.println(comeout);
                op[j+i] += comeout%10;
                op[j+i+1] += comeout/10;
            }
        }
        int temp = 0;
        for (int i = 0; i < 200; i++) {
            op[i] += temp;
            temp = op[i] / 10;
            op[i] = op[i] % 10;
            outBuilder.insert(0,op[i]);
        }
        temp = 199;
        for (int i = 0; i < 200; i++) {
            if (outBuilder.charAt(i) != '0'){
                temp = i;
                break;
            }
        }
        return outBuilder.substring(temp).toString();
    }
}