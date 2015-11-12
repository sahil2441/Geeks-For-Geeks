package dynamic_programming;

public class CoinChange {

	public static void main(String[] args) {
		int n = 10;
		int[] arr = { 2, 3, 5, 6 };
		System.out.println(getCoinChange(arr, n));
	}

	private static int getCoinChange(int[] arr, int n) {

		int[][] table = new int[arr.length][n + 1];
		for (int i = 0; i < table.length; i++) {
			table[i][0] = 1;
		}
		for (int i = 0; i < table[0].length; i++) {
			table[0][i] = i % arr[0] == 0 ? 1 : 0;
		}

		for (int i = 1; i < table.length; i++) {
			for (int j = 1; j < table[0].length; j++) {
				if (arr[i] > j) {
					table[i][j] = table[i - 1][j];
				} else {
					table[i][j] = table[i - 1][j] + table[i][j - arr[i]];
				}
			}
		}

		return table[arr.length - 1][n];
	}

}
