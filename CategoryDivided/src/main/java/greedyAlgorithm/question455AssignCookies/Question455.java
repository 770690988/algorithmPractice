package greedyAlgorithm.question455AssignCookies;

/**
 * @Author yucl2030
 * @Description 分发饼干题解
 * @Date 2023/9/6 9:12
 */

import java.util.Arrays;

/**
 * 假设你是一位很棒的家长，想要给你的孩子们一些小饼干。但是，每个孩子最多只能给一块饼干。对每个孩子i，
 * 都有一个胃口值g[i],这是能让孩子们满足胃口的饼干的最小尺寸；
 * 并且每块饼干j,都有一个尺寸s[j]。如果 s[i]>=g[i],我们可以将这个饼干j分配给孩子i，这个孩子会得到满足。
 * 你的目标是尽可能满足越多数量的孩子，并输出这个最大数值。
 */
public class Question455 {
    public static void main(String[] args) {
        int[] g = {1, 2, 3};
        int[] s = {2, 2, 2};
        System.out.println(new Solution().findContentChildren(g, s));
    }
}

class Solution {
    public int findContentChildren(int[] g, int[] s) {
        int count = 0;
        Arrays.sort(g);
        Arrays.sort(s);
        int sIndex = s.length - 1;
        for (int i = g.length - 1; i >= 0; i--) {
            if (sIndex < 0) {
                break;
            }
            if (s[sIndex] >= g[i]) {
                count++;
                sIndex--;
            }
        }
        return count;
    }
}
