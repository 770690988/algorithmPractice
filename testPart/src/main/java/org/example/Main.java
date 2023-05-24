package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @Author puka
 * @Description TODO
 * @Date 2023/5/17 15:56
 */
public class Main {
    public static void main(String[] args) {
        Integer i5 = 128;
        Integer i6 = 128;
        List<Integer> data = new ArrayList<>();
        data.add(i5);
        data.add(i6);
        System.out.println(Arrays.toString(data.toArray()));
        System.out.println(Arrays.toString(data.toArray()));

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