package dynamic_programming;

public class Knapsack {

	public static void main(String[] args) {

		int[] wt = { 10, 20, 30 };
		int w = 50;
		int[] val = { 60, 100, 120 };
		int n = wt.length;

		System.out.println(knapsackUsingDP(wt, val, w, n));
	}

	private static int knapsackUsingDP(int[] wt, int[] val, int w, int n) {
		int[][] table = new int[n + 1][w + 1];

		for (int i = 0; i <= n; i++) {
			for (int windex = 0; windex <= wt.length; windex++) {
				if (i == 0 || windex == 0)
					table[i][windex] = 0;
				else if (wt[i - 1] <= windex)
					table[i][windex] = max(val[i - 1] + table[i - 1][windex - wt[i - 1]], table[i - 1][windex]);
				else
					table[i][windex] = table[i - 1][windex];
			}
		}

		return table[n][w];
	}

	private static int max(int i, int j) {
		return i > j ? i : j;
	}

	private static int knapsack(int[] wt, int[] val, int w, int n) {
		if (w == 0 || n == 0)
			return 0;
		if (w >= wt[n - 1])
			return knapsack(wt, val, w - wt[n - 1], n - 1) + val[n - 1] > knapsack(wt, val, w, n - 1)
					? knapsack(wt, val, w - wt[n - 1], n - 1) + val[n - 1] : knapsack(wt, val, w, n - 1);
		return knapsack(wt, val, w, n - 1);
	}

}
