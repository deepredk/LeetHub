class Solution {
    public long[] maximumCoins(int[] heroes, int[] monsters, int[] coins) {
        // 1. 몬스터, 코인 정렬 (nlogn)
        List<Monster> mList = new ArrayList<>();
        for (int i = 0; i < monsters.length; i++) {
            Monster m = new Monster(monsters[i], coins[i]);
            mList.add(m);
        }
        mList.sort((a, b) -> a.power - b.power);

        // 2. 코인 부분합 (n)
        long[] pSum = new long[coins.length];
        pSum[0] = mList.get(0).coin;
        for (int i = 1; i < coins.length; i++) {
            pSum[i] = pSum[i-1] + mList.get(i).coin;
        }

        // 3. 히어로마다 이진탐색 (mlogm)
        long[] ans = new long[heroes.length];
        for (int i = 0; i < heroes.length; i++) {
            int topIdx = binarySearch(mList, heroes[i]);
            if (topIdx == -1) continue;
            ans[i] = pSum[topIdx];
        }

        // nlogn + n + mlogm
        return ans;
    }

    private int binarySearch(List<Monster> monsters, int hero) {
        int left = 0;
        int right = monsters.size() - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (monsters.get(mid).power <= hero) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return right;
    }

    class Monster {
        public int power;
        public int coin;

        public Monster(int power, int coin) {
            this.power = power;
            this.coin = coin;
        }

        @Override
        public String toString() {
            return "(" + power + "," + coin + ")";
        }
    }
}