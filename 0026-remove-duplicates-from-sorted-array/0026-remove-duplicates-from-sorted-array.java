class Solution {
    public int removeDuplicates(int[] nums) {
        int k = 1;
        for(int i=1; i<nums.length; i++){
            if(nums[i] == nums[i-1]){
                continue;
            } else{
                nums[k] = nums[i];
                k += 1;
            }

        }
        return k;
    }
}


// int k = 1;
//         for(int j = 1; j<nums.length; j++){
//             if(nums[j] != nums[j-1]){
//                 nums[k] = nums[j];
//                 k = k+1;
//             }
//         }
//         return k;