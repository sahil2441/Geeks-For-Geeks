package dynamic_programming;

public class MatrixChainMultuplication {

	public static void main(String[] args) {
		int n = 10;
		int[] arr = { 40, 20, 30, 10, 30, 10, 20 };
		System.out.println(matrixChainMultiply(arr));
	}

	private static int matrixChainMultiply(int[] arr) {
		int[][] table = new int[arr.length][arr.length];
		for (int i = 0; i < table.length; i++) {
			table[i][i] = 0;
			if (i < arr.length - 1) {
				table[i][i + 1] = arr[i] * arr[i + 1];
			}
			if (i < arr.length - 2) {
				table[i][i + 2] = arr[i] * arr[i + 1] * arr[i + 2];
			}
		}

		for (int i = 3; i < table.length; i++) {
			for (int j = 0; j < table.length - i; j++) {
				table[j][j + i] = findMin(table, j, i);
			}
		}
		return table[0][table.length - 1];
	}

	private static int findMin(int[][] table, int row, int col) {
		int min = Integer.MAX_VALUE;

		for (int i = 2; i < row; i++) {
			int x = table[row][i] * table[i][col];
			if (x < min) {
				min = x;
			}
		}
		return min;
	}

}
