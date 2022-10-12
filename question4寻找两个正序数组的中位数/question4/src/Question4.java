import java.util.ArrayList;
import java.util.List;

public class Question4 {
    public static void main(String[] args) {
        int[] nums1 = {3,4};
        int[] nums2 = {};
        Solution solution = new Solution();
        double out = solution.findMedianSortedArrays(nums1, nums2);
        System.out.println(out);
    }
}


class Solution {
    //解法1 先将两个数组合并，然后计算中间的中位数返回
    //优化1：但是考虑到中位数不需要所有的数字都包含，所以其实只要排到中间就可以停止了
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        Integer lenAll = nums1.length + nums2.length;
        List<Integer> dataList = new ArrayList<>();
        Integer flag1 = 0;
        Integer flag2 = 0;
        Integer num1;
        Integer num2;
        Integer numOut = null;
        for (int i = 0; i <= lenAll / 2; i++){
            if (flag1 < nums1.length){
                num1 = nums1[flag1];
            }
            else{
                num1 = null;
            }
            if (flag2 < nums2.length){
                num2 = nums2[flag2];
            }
            else {
                num2 = null;
            }
            if (num1 == null || (num2 != null && num1 >= num2)){
                numOut = num2;
                flag2++;
            }
            else{
                numOut = num1;
                flag1++;
            }
            dataList.add(numOut);
        }
        if (dataList.size() == 0){
            return 0;
        }
        if (lenAll % 2 != 0){
            return dataList.get(dataList.size()-1);
        }
        else {
            return (dataList.get(dataList.size()-1) + dataList.get(dataList.size()-2)) / 2.0;
        }

    }

    public double findMedianSortedArrays1(int[] nums1, int[] nums2) {
        int sum = nums1.length + nums2.length;
        boolean isO = sum % 2 == 0;
        int m = sum / 2;

        int i1 = 0, i2 = 0;
        int m1 = 0, m2 = 0;
        int length = 0;
        for (int i = 0; i < sum; i++) {
            int k;
            if (i2 >= nums2.length || i1 < nums1.length && nums1[i1] < nums2[i2]) {
                k = nums1[i1];
                i1++;
            } else {
                k = nums2[i2];
                i2++;
            }
            if (length == m) {
                m2 = k;
                break;
            }
            if (isO && length == m - 1) {
                m1 = k;
            }
            length++;
        }
        if (m1 == 0) {
            return m2;
        } else {
            return (m1 + m2) / 2.0;
        }
    }
}
