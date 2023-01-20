public class Question28 {
    public static void main(String[] args) {
        String haystack = "mississippi";
        String needle = "issippi";
        Solution out = new Solution();
        System.out.println("普通方法答案:" + out.strStr(haystack, needle));
        System.out.println("KMP方法答案:" + out.strStr1(haystack, needle));
    }

}

class Solution {
    /**
     * 这个是最普通的算法，时间复杂度为o(m*n)
     * @param haystack
     * @param needle
     * @return int
     */
    public int strStr(String haystack, String needle) {
        Integer stackLen = haystack.length();
        Integer needleLen = needle.length();
        if (stackLen < needleLen) return -1;
        for (int i = 0; i < stackLen; i++) {
            if (i+needleLen > stackLen) break;
            for (int j = 0; j < needleLen; j++) {
//                if (i+j >= stackLen) break;
                if (haystack.charAt(i+j) != needle.charAt(j)){
                    break;
                } else if (j == needleLen-1) {
                    return i;
                }
            }
        }
        return -1;
    }

    /**
     * KMP算法，减少重复比较的次数
     * @param haystack
     * @param needle
     * @return int
     */
    public int strStr1(String haystack, String needle) {
        Integer stackLen = haystack.length();
        Integer needleLen = needle.length();
        //计算Next数组
        Integer[] next = new Integer[needleLen];
        next[0] = 0;
        Integer maxPrefix = 0;
        for (int i = 1; i < needleLen; i++) {
            if (needle.charAt(i) == needle.charAt(maxPrefix)){
                next[i] = ++maxPrefix;
            } else if (maxPrefix == 0) {
                next[i] = 0;
            }else {
                maxPrefix = next[maxPrefix - 1];//退回到next递推点进行计算
                i--;//也就是重新判断
            }
        }

        int j = 0;
        //有了next数组之后开始递推
        for (int i = 0; i < stackLen; i++) {
            if (haystack.charAt(i) != needle.charAt(j)){
                if (j != 0){
                    j = next[j-1];
                    i--;
                }
                continue;
            }
            if (j == needleLen - 1) return i-j;
            j++;
        }

        return -1;
    }
}