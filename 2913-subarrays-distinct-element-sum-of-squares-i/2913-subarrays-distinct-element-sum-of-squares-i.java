class Solution {
    public int sumCounts(List<Integer> nums) {
        int total = 0;

        for (int start = 0; start < nums.size(); start++) {
            Set<Integer> distinct = new HashSet<>();

            for (int end = start; end < nums.size(); end++) {
                distinct.add(nums.get(end));
                total += distinct.size() * distinct.size();
            }
        }

        return total;
    }
}