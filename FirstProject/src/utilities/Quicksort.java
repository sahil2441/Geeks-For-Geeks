package utilities;

import java.util.Arrays;

public class Quicksort {

	public static void main(String[] args) {
		int[] arr = { 8, 5, 2, 7, 6, 14 };
		int start = 0;
		int end = arr.length - 1;

		System.out.println("Unsorted:" + Arrays.toString(arr));
		quicksorting(arr, start, end);
		System.out.println("Sorted:" + Arrays.toString(arr));
	}

	public static void quicksorting(int[] arr, int start, int end) {

		if (start >= end)
			return;

		if (start < end) {
			int index = partition(arr, start, end);
			quicksorting(arr, start, index - 1);
			quicksorting(arr, index + 1, end);
		}
	}

	public static int partition(int[] arr, int start, int end) {
		int pivot = arr[start];
		int i = start + 1;
		int j = end;

		while (i < j) {
			if (arr[i] < pivot)
				i++;
			else if (arr[j] > pivot)
				j--;
			else
				swap(arr, i, j);
		}

		int index = i - 1;
		// swap(arr, start, index);
		arr[start] = arr[index];
		arr[index] = pivot;
		return index;
	}

	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

}
