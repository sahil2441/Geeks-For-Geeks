/**
 * 
 * @author sahil
 */
public class MaximumProductSubarray {

	public static void main(String[] args) {

		int[] arr = { -1, -3, -10, 0, 60 };
		System.out.println(maximumProduct(arr));
	}

	private static int maximumProduct(int[] arr) {
		// max positive product ending at the current position
		int max_ending_here = 1;

		// min negative product ending at the current position
		int min_ending_here = 1;

		// Initialize overall max product
		int max_so_far = 1;

		for (int i = 0; i < arr.length; i++) {

			if (arr[i] == 0) {
				max_ending_here = 1;
				min_ending_here = 1;
			} else if (arr[i] > 0) {
				max_ending_here *= arr[i];
				min_ending_here *= arr[i];
			} else {
				int temp = max_ending_here;
				max_ending_here = min_ending_here * arr[i];
				min_ending_here = temp * arr[i];
			}

			if (max_ending_here > max_so_far)
				max_so_far = max_ending_here;
		}

		return max_so_far;
	}
}
