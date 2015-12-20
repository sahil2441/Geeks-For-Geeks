/**
 * 
 * @author sahil
 */
public class MaximumSum {

	public static void main(String[] args) {

		int[] arr = { 5, 5, 10, 40, 50, 35 };
		System.out.println(maximumSum(arr, arr.length));
	}

	private static int maximumSum(int[] arr, int n) {
		int[] incl = new int[n];
		int[] excl = new int[n];

		incl[0] = arr[0];
		incl[1] = arr[1];

		excl[0] = 0;
		excl[1] = incl[0];

		for (int i = 2; i < excl.length; i++) {
			incl[i] = arr[i] + max(incl[i - 2], excl[i - 1]);
			excl[i] = max(incl[i - 1], excl[i - 1]);
		}

		return incl[n - 1] > excl[n - 1] ? incl[n - 1] : excl[n - 1];
	}

	private static int max(int i, int j) {
		return i > j ? i : j;
	}

}
