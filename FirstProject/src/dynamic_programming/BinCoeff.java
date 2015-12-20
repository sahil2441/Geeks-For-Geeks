package dynamic_programming;

public class BinCoeff {

	public static void main(String[] args) {
		int n = 10;
		int k = 4;
		System.out.println(binomialCoefficient(n, k));
	}

	private static int binomialCoefficient(int n, int k) {
		if (n < 0 || k < 0 || k > n)
			return -1;

		int[][] table = new int[n + 1][k + 1];
		for (int i = 0; i < table[0].length; i++) {
			table[i][i] = 1;
		}
		for (int i = 0; i < table.length; i++) {
			table[i][0] = 1;
		}
		for (int i = 1; i < table.length; i++) {
			for (int j = 1; j < table[0].length; j++) {
				if (j > i)
					break;
				table[i][j] = table[i - 1][j - 1] + table[i - 1][j];
			}
		}

		return table[n][k];
	}
}
