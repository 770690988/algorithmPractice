public class Question35 {
    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};
        Solution out = new Solution();
        System.out.println("The answer is "+ out.jump(nums));
    }
}

class Solution {
    public int jump(int[] nums) {
        int curDistance = 0;
        int nextDistance = 0;
        int ans = 0;
        for (int i = 0; i < nums.length-1; i++) {
            if (i == curDistance+1){
                ans++;
                curDistance = nextDistance;
            }
            nextDistance = Integer.max(i + nums[i],nextDistance);
        }
        return ans;
    }
}
