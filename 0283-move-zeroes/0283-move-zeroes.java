class Solution {
    public void moveZeroes(int[] nums) {
        int[] result = new int[nums.length];
        
        int idx = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) continue;
            result[idx++] = nums[i];
        }

        for (int i = 0; i < idx; i++) {
            nums[i] = result[i];
        }
        for (int i = idx; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}