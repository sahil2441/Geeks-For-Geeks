import java.util.Arrays;

public class MergeTwoSortedArrays {

	public static void main(String[] args) {
		int[] firstArray = { 2, 8, -1, -1, -1, 13, -1, 15, 20 };
		int[] secondArray = { 5, 7, 9, 25 };
		move(firstArray);
		merge(firstArray, secondArray);
		System.out.println(Arrays.toString(firstArray));
	}

	private static void merge(int[] firstArray, int[] secondArray) {

		int n = firstArray.length;
		int m = secondArray.length;

		int index1 = m;
		int index2 = 0;
		int index = 0;

		while (index < m) {

			if (index == n || firstArray[index1] <= secondArray[index] && index1 < n) {
				firstArray[index2] = firstArray[index1];
				index2++;
				index1++;
			} else {
				firstArray[index2] = secondArray[index];
				index2++;
				index++;
			}
		}

	}

	private static void move(int[] arr) {
		int x = arr.length - 1;
		for (int i = arr.length - 1; i >= 0; i--) {
			if (arr[i] != -1) {
				arr[x] = arr[i];
				x--;
			}
		}

	}

}
