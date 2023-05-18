package org.example;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author puka
 * @Description TODO
 * @Date 2023/5/17 16:15
 */
public class Main {
    public static void main(String[] args) {
        int[] height = {4,2,0,3,2,5};
        System.out.println(new Solution().trap(height));
    }
}

class Solution {
    public int trap(int[] height) {
        int sum = 0;
        int max = getMax(height);//找到最大的高度，以便遍历。
        for (int i = 1; i <= max; i++) {
            boolean isStart = false; //标记是否开始更新 temp
            int temp_sum = 0;
            for (int j = 0; j < height.length; j++) {
                if (isStart && height[j] < i) {
                    temp_sum++;
                }
                if (height[j] >= i) {
                    sum = sum + temp_sum;
                    temp_sum = 0;
                    isStart = true;
                }
            }
        }
        return sum;
    }
    private int getMax(int[] height) {
        int max = 0;
        for (int i = 0; i < height.length; i++) {
            if (height[i] > max) {
                max = height[i];
            }
        }
        return max;
    }
}