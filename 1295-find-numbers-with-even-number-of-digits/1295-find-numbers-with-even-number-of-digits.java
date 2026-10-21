class Solution {
    public boolean numhasEvenDegits(int num){
        int degitCount =0;

        while(num != 0){
            num = num /10;
            degitCount++;
        }
        return degitCount%2 == 0;
    }


    public int findNumbers(int[] nums) {
        int evenCount = 0;

        for(int i=0; i<nums.length; i++){
            if(numhasEvenDegits(nums[i])){
                evenCount++;
            }
        }
        return evenCount;
    }
}