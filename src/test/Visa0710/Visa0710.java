package src.test.Visa0710;

import java.util.*;
import java.util.HashMap;
import java.util.Map;

public class Visa0710 {
    public int[] handleCacheQueries(String[][] cacheEntries, String[][] queries) {
        // 1. 构建哈希表，用于 O(1) 查找
        Map<String, Integer> cache = new HashMap<>();

        for (String[] entry : cacheEntries) {
            String timestamp = entry[0];
            String key = entry[1];
            int value = Integer.parseInt(entry[2]);

            // 拼接唯一标识符: "key#timestamp"
            String compositeKey = key + "#" + timestamp;
            cache.put(compositeKey, value);
        }

        // 2. 依次处理每个查询
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            String key = queries[i][0];
            String timestamp = queries[i][1];

            String compositeKey = key + "#" + timestamp;
            ans[i] = cache.get(compositeKey);
        }

        return ans;
    }

    public static long computeCompressionLoss(List<Integer> featureMap) {
        long totalLoss = 0;
        long currentSegmentLength = 0;

        for (int num : featureMap) {
            if (num == 1) {
                currentSegmentLength++;
            } else {
                // 遇到 0，结算上一段连续 1 的贡献
                if (currentSegmentLength > 0) {
                    totalLoss += currentSegmentLength * (currentSegmentLength + 1) / 2;
                    currentSegmentLength = 0; // 重置长度
                }
            }
        }

        // 循环结束后，不要漏掉结尾最后一段连续的 1
        if (currentSegmentLength > 0) {
            totalLoss += currentSegmentLength * (currentSegmentLength + 1) / 2;
        }

        return totalLoss;
    }



    public static int optimalJourneyTotal(List<Integer> cities) {
        int n = cities.size();
        if (n == 0) return 0;

        // 1. 预处理：筛出 1 到 n 之间所有以 3 结尾的质数
        List<Integer> validPrimes = getPrimesEndingIn3(n);

        // 2. 初始化 DP 数组
        int[] dp = new int[n];
        // 初始化为一个足够小的数，防止加法溢出，用 Integer.MIN_VALUE / 2
        Arrays.fill(dp, Integer.MIN_VALUE / 2);

        // 起始点城市 0
        dp[0] = cities.get(0);

        // 3. 动态规划递推
        for (int i = 1; i < n; i++) {
            // 途径一：从相邻的上一格 (i - 1) 走过来
            int maxPrev = dp[i - 1];

            // 途径二：从相距 p 步的格 (i - p) 跳跃过来
            for (int p : validPrimes) {
                if (p > i) break; // 步数超出了当前位置，直接中断
                maxPrev = Math.max(maxPrev, dp[i - p]);
            }

            // 更新到达当前城市 i 的最大收益
            dp[i] = maxPrev + cities.get(i);
        }

        // 返回到达最后一个城市 (n - 1) 的最大收益
        return dp[n - 1];
    }

    // 辅助函数：埃氏筛法获取所有 <= maxVal 且以 3 结尾的质数
    private static List<Integer> getPrimesEndingIn3(int maxVal) {
        boolean[] isPrime = new boolean[maxVal + 1];
        Arrays.fill(isPrime, true);
        if (maxVal >= 0) isPrime[0] = false;
        if (maxVal >= 1) isPrime[1] = false;

        for (int p = 2; p * p <= maxVal; p++) {
            if (isPrime[p]) {
                for (int i = p * p; i <= maxVal; i += p) {
                    isPrime[i] = false;
                }
            }
        }

        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= maxVal; i++) {
            if (isPrime[i] && i % 10 == 3) { // 满足质数且个位为 3
                primes.add(i);
            }
        }
        return primes;
    }
}
