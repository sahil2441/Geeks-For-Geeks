package dynamic_programming;

public class LongestCommonSubsequence {

	public static void main(String[] args) {
		String s = "ABCDGH";
		String t = "AEDFHRABCDGH";
		int l1 = s.length();
		int l2 = t.length();
		int[][] table = new int[l1][l2];

		int max = 0;
		for (int i = 0; i < table[0].length; i++) {
			table[0][i] = s.charAt(0) == t.charAt(i) ? 1 : 0;
			if (max < table[0][i])
				max = table[0][i];
			if (table[0][i] < max)
				table[0][i] = max;
		}

		max = 0;
		for (int i = 0; i < table.length; i++) {
			table[i][0] = s.charAt(i) == t.charAt(0) ? 1 : 0;
			if (max < table[i][0])
				max = table[i][0];
			if (table[i][0] < max)
				table[i][0] = max;
		}

		for (int i = 1; i < table.length; i++) {
			for (int j = 1; j < table[0].length; j++) {
				if (s.charAt(i) == t.charAt(j)) {
					table[i][j] = table[i - 1][j - 1] + 1;
				} else {
					table[i][j] = max(table[i - 1][j - 1], table[i - 1][j], table[i][j - 1]);
				}
			}
		}
		System.out.println("Longest Subsequence: " + table[l1 - 1][l2 - 1]);
	}

	private static int max(int i, int j, int k) {
		int max = i > j ? i : j;
		max = max > k ? max : k;
		return max;
	}
}
