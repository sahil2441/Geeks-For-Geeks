package dynamic_programming;

public class EditDistance {

	public static void main(String[] args) {
		String s = "abra";
		String t = "kabra";

		int[][] table = new int[s.length() + 1][t.length() + 1];
		for (int i = 0; i < table.length; i++) {
			table[i][0] = i;
		}
		for (int i = 0; i < table[0].length; i++) {
			table[0][i] = i;
		}

		for (int i = 1; i < table.length; i++) {
			for (int j = 1; j < table[0].length; j++) {
				if (s.charAt(i - 1) == t.charAt(j - 1)) {
					table[i][j] = table[i - 1][j - 1];
				} else {
					table[i][j] = 1 + min(table[i - 1][j], table[i - 1][j - 1], table[i][j - 1]);
				}
			}
		}
		printTable(table);

	}

	private static void printTable(int[][] table) {
		for (int i = 0; i < table.length; i++) {
			for (int j = 0; j < table[0].length; j++) {
				System.out.print(table[i][j] + ",");
			}
			System.out.println();
		}
	}

	private static int min(int i, int j, int k) {
		int min = i < j ? i : j;
		return min < k ? min : k;
	}

}
