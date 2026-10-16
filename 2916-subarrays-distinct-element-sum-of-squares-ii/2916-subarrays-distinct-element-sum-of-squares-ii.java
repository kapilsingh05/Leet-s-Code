import java.util.HashMap;
import java.util.Map;

class Solution {
    private static final long MOD = 1_000_000_007L;

    private long[] sum;
    private long[] sumSquares;
    private long[] lazy;

    public int sumCounts(int[] nums) {
        int n = nums.length;
        sum = new long[4 * n];
        sumSquares = new long[4 * n];
        lazy = new long[4 * n];

        Map<Integer, Integer> lastSeen = new HashMap<>();
        long answer = 0;

        for (int i = 0; i < n; i++) {
            int previous = lastSeen.getOrDefault(nums[i], -1);

            // Add 1 to counts for subarrays starting after the previous occurrence.
            add(1, 0, n - 1, previous + 1, i, 1);

            // The root holds the squared-count sum for subarrays ending at i.
            answer = (answer + sumSquares[1]) % MOD;
            lastSeen.put(nums[i], i);
        }

        return (int) answer;
    }

    private void add(int node, int left, int right,
                     int queryLeft, int queryRight, long value) {
        if (queryLeft <= left && right <= queryRight) {
            apply(node, left, right, value);
            return;
        }

        pushDown(node, left, right);

        int middle = (left + right) / 2;
        if (queryLeft <= middle) {
            add(node * 2, left, middle, queryLeft, queryRight, value);
        }
        if (queryRight > middle) {
            add(node * 2 + 1, middle + 1, right, queryLeft, queryRight, value);
        }

        sum[node] = (sum[node * 2] + sum[node * 2 + 1]) % MOD;
        sumSquares[node] =
                (sumSquares[node * 2] + sumSquares[node * 2 + 1]) % MOD;
    }

    private void apply(int node, int left, int right, long value) {
        long length = right - left + 1L;
        long oldSum = sum[node];

        sumSquares[node] = (
                sumSquares[node]
                + 2 * value * oldSum
                + value * value % MOD * length
        ) % MOD;

        sum[node] = (oldSum + value * length) % MOD;
        lazy[node] = (lazy[node] + value) % MOD;
    }

    private void pushDown(int node, int left, int right) {
        if (lazy[node] == 0 || left == right) {
            return;
        }

        int middle = (left + right) / 2;
        apply(node * 2, left, middle, lazy[node]);
        apply(node * 2 + 1, middle + 1, right, lazy[node]);
        lazy[node] = 0;
    }
}