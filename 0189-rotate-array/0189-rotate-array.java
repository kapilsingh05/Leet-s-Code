class Solution {
    public void rev(int[] nums, int start, int end){
        while(start <= end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public void rotate(int[] nums, int k) {
        int n = nums.length;

        if(k % n == 0){
            return;
        }

        k = k % n;
        rev(nums, 0, n-1);
        rev(nums, 0, k-1);
        rev(nums, k, n-1);
    }
}























// class Solution {
//     public void rotate(int[] nums, int k) {
//         int n = nums.length;
//         if (n == 0) return;

//         k %= n;
//         reverse(nums, 0, n - 1);
//         reverse(nums, 0, k - 1);
//         reverse(nums, k, n - 1);
//     }

//     private void reverse(int[] nums, int left, int right) {
//         while (left < right) {
//             int temp = nums[left];
//             nums[left] = nums[right];
//             nums[right] = temp;
//             left++;
//             right--;
//         }
//     }
// }