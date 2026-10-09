import java.util.*;

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> s1 = new HashSet<>();
        Set<Integer> s2 = new HashSet<>();

        for (int num : nums1) {
            s1.add(num);
        }

        for (int num : nums2) {
            if (s1.contains(num)) {
                s2.add(num);
            }
        }

        int[] res = new int[s2.size()];
        int i = 0;

        for (int num : s2) {
            res[i++] = num;
        }

        return res;
    }
}