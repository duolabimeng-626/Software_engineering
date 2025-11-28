public class MaxSubarraySum {

    public static int maxSubArray(int[] nums) {
        // 初始化
        int currentSum = nums[0];  // 以第一个数开头
        int maxSum = nums[0];

        // 从第二个元素开始遍历
        for (int i = 1; i < nums.length; i++) {
            // 如果 currentSum < 0，重新开始，否则加上当前数
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            // 更新全局最大值
            maxSum = Math.max(maxSum, currentSum);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, -2, 3, 5, -1};
        int[] arr2 = {1, -2, 3, -8, 5, 1};
        int[] arr3 = {1, -2, 3, -2, 5, 1};

        System.out.println(maxSubArray(arr1)); // 8
        System.out.println(maxSubArray(arr2)); // 6
        System.out.println(maxSubArray(arr3)); // 7
    }
}
