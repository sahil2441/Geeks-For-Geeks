
public class NextGreaterNumber {

	public static void main(String[] args) {
		String a = "534937";
		System.out.println(printNextGreaterNumber(a));
	}

	private static String printNextGreaterNumber(String a) {
		if (a.length() <= 1) {
			return "Not Possible";
		} else {
			int targetIndex = 0, leastIndex;
			int i = a.length() - 1;
			while (i > 0) {
				if (a.charAt(i - 1) > a.charAt(i)) {
					targetIndex = i - 1;
					leastIndex = findLeastIndex(a, targetIndex);
					swap(a, targetIndex, leastIndex);
				}
			}
			// Sort elts b/w target index+1 and n
			sortString(targetIndex + 1, a);
			return a;
		}
	}

	private static void sortString(int i, String a) {

	}

	private static void swap(String a, int targetIndex, int leastIndex) {
		char[] arr = a.toCharArray();
		char temp = arr[targetIndex];
		arr[targetIndex] = arr[leastIndex];
		arr[leastIndex] = temp;
		/*
		 * String newString=new String(arr); return newString;
		 */ }

	private static int findLeastIndex(String a, int targetIndex) {
		return 0;
	}

}
