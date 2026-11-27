class Solution {
    public int maximumSaleItems(int[][] items, int budget) {
        int n = items.length;

        int[] dp = new int[budget + 1];

        int minPrice = Integer.MAX_VALUE;

        for (int[] item : items) {
            minPrice = Math.min(minPrice, item[1]);
        }

        for (int[] item : items) {
            int factor = item[0];
            int price = item[1];

            int count = 0;

            for (int[] other : items) {
                if (other[0] % factor == 0) {
                    count++;
                }
            }

            for (int j = budget; j >= price; j--) {
                dp[j] = Math.max(dp[j], dp[j - price] + count);
            }
        }

        int ans = 0;

        for (int spent = 0; spent <= budget; spent++) {
            int extra = (budget - spent) / minPrice;

            ans = Math.max(ans, dp[spent] + extra);
        }

        return ans;
    }
}