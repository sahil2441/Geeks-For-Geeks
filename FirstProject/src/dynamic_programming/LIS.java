package dynamic_programming;

/**
 * LIS
 * 
 * @author sahiljain
 *
 */
public class LIS {

	public static void main(String[] args) {
		int[] arr = { 1, 2, -1, -3, -2, 4 };
		System.out.println(lis(arr));
	}

	private static int lis(int[] arr) {
		int[] result = new int[arr.length];
		for (int i = 0; i < result.length; i++) {
			result[i] = 1;
		}

		for (int i = 0; i < result.length; i++) {
			for (int j = 0; j < i; j++) {
				if (arr[i] >= arr[j] && result[j] + 1 > result[i])
					result[i] = result[j] + 1;
			}
		}
		return result[arr.length - 1];

	}
}
