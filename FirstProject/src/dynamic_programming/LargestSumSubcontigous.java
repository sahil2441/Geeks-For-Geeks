package dynamic_programming;

/**
 * Kadane's Algorithm
 * 
 * @author sahiljain
 *
 */
public class LargestSumSubcontigous {

	public static void main(String[] args) {
		int[] arr = { -2, -3, 4, -1, -2, 1, 5, -3 };
		System.out.println(kadaneAlgo(arr));
	}

	private static int kadaneAlgo(int[] arr) {

		int maxSoFar = 0;
		int maxEndingHere = 0;

		for (int i = 0; i < arr.length; i++) {
			maxEndingHere += arr[i];
			if (maxEndingHere < 0) {
				maxEndingHere = 0;
			}

			if (maxEndingHere > maxSoFar) {
				maxSoFar = maxEndingHere;
			}
		}
		return maxSoFar;

	}
}
