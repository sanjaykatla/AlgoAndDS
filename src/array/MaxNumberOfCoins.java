package array;

public class MaxNumberOfCoins {
    public int maxCoins(int[] piles) {

        int result = 0;

        sort(piles);

        for (int i = piles.length - 2; i >= piles.length / 3; i -= 2) {
            result += piles[i];
        }
        return result;
    }

    private void sort(int[] piles) {
        final int[] freq = new int[10001];
        for (int pile : piles) {
            freq[pile]++;
        }

        int idx = 0;
        for (int i = 0; i < 10001; i++) {
            while (freq[i] > 0) {
                piles[idx++] = i;
                freq[i]--;
            }
        }
    }
}
