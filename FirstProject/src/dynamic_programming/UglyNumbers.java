package dynamic_programming;

/**
 * Ugly Numbers
 * 
 * @author sahiljain
 *
 */
public class UglyNumbers {

	public static void main(String[] args) {
		int x = 150;
		findUglyNumber(x);
	}

	private static void findUglyNumber(int x) {
		int[] ugly = new int[x];
		ugly[0] = 1;
		System.out.println(ugly[0]);

		int i2 = 0, i3 = 0, i5 = 0;
		int next_multiple_2 = ugly[i2] * 2;
		int next_multiple_3 = ugly[i3] * 3;
		int next_multiple_5 = ugly[i5] * 5;

		for (int i = 1; i < ugly.length; i++) {

			int min = findMin(next_multiple_2, next_multiple_3, next_multiple_5);
			ugly[i] = min;

			if (min == next_multiple_2) {
				i2++;
				next_multiple_2 = ugly[i2] * 2;
			}

			if (min == next_multiple_3) {
				i3++;
				next_multiple_3 = ugly[i3] * 3;
			}

			if (min == next_multiple_5) {
				i5++;
				next_multiple_5 = ugly[i5] * 5;
			}

			System.out.println(ugly[i]);
		}
	}

	private static int findMin(int next_multiple_2, int next_multiple_3, int next_multiple_5) {
		int x = next_multiple_2 < next_multiple_3 ? next_multiple_2 : next_multiple_3;
		return x < next_multiple_5 ? x : next_multiple_5;
	}

}
