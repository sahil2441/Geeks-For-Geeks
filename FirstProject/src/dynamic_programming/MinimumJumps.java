package dynamic_programming;

public class MinimumJumps {

	public static void main(String[] args) {
		int[] arr = { 1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9 };
		System.out.println(findMinJumps(arr));
	}

	private static int findMinJumps(int[] arr) {
		int[] min_jumps = new int[arr.length];
		int n = arr.length;

		min_jumps[n - 1] = 0;
		for (int i = arr.length - 2; i >= 0; i--) {
			if (arr[i] >= n - 1 - i) {
				min_jumps[i] = 1;
			} else {
				min_jumps[i] = 1 + get_min(min_jumps, i + 1, i + arr[i]);
			}
		}

		return min_jumps[0];
	}

	private static int get_min(int[] min_jumps, int i, int j) {
		int min = min_jumps[i];
		for (int k = i; k <= j; k++) {
			if (min_jumps[k] < min) {
				min = min_jumps[k];
			}
		}
		return min;
	}

}
