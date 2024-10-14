class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int canPlaces = 0;

        int blankStreak = 1;
        for (int bed : flowerbed) {
            if (bed == 0) {
                blankStreak++;
                continue;
            }
            
            if (blankStreak >= 3) {
                canPlaces += (blankStreak-1) / 2;
            }
            blankStreak = 0;
        }

        blankStreak++;
        if (blankStreak >= 3) {
            canPlaces += (blankStreak-1) / 2;
        }


        return canPlaces >= n;
    }
}