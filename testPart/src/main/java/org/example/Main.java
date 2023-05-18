package org.example;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @Author puka
 * @Description TODO
 * @Date 2023/5/17 15:56
 */
public class Main {
    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int target = 9;
        System.out.println(Arrays.toString(new Solution().twoSum(nums,target)));
    }
}

class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> restMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (restMap.containsKey(nums[i])){
                return new int[]{restMap.get(nums[i]), i};
            }else {
                restMap.put(target-nums[i],i);
            }
        }
        return null;
    }
}