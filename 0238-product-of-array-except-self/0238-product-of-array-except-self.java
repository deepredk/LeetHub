class Solution {
    public int[] productExceptSelf(int[] nums) {
        int product = 1;

        int zeroCount = 0;
        int zeroIdx = -1;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (num == 0) {
                zeroCount++;
                zeroIdx = i;
                continue;
            }
            product *= num;
        }

        if (zeroCount >= 2) {
            return new int[nums.length];
        }
        if (zeroCount == 1) {
            int[] answer = new int[nums.length];
            answer[zeroIdx] = product;
            return answer;
        }

        int[] answer = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            answer[i] = product / nums[i];
        }
        return answer;
    }
}