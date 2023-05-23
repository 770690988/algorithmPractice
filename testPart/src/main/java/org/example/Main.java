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
        int size = 100000;
        Double data = (double) 0;
        int[] nums = new int[size];
        for (int i = 0; i < size; i++) {
            nums[i] = i;
        }

        long start = System.currentTimeMillis();
        int sum = Arrays.stream(nums).sum();
        long end = System.currentTimeMillis();
        System.out.println("stream串行流" + (end - start) + "ms");

        start = System.currentTimeMillis();
        sum = Arrays.stream(nums).parallel().sum();
        end = System.currentTimeMillis();
        System.out.println("stream并行流" + (end - start) + "ms");

        start = System.currentTimeMillis();
        for(int num : nums){
            data += num;
        }
        end = System.currentTimeMillis();
        System.out.println("foreach总耗时" + (end - start) + "ms");
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