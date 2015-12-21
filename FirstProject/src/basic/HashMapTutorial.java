package basic;
import java.util.HashMap;

/**
 * 
 * @author sahil
 */
public class HashMapTutorial {

	public static void main(String[] args) {

		int sum = 16;
		int[] arr = { 1, 4, 45, 6, 10, -8 };
		HashMap<Integer, Boolean> map = new HashMap<>();

		for (int i = 0; i < arr.length; i++) {

			int complementaryElement = sum - arr[i];
			if (map.get(complementaryElement) != null) {
				System.out.println("Answer is : " + arr[i]);
			} else {
				map.put(arr[i], true);
			}

		}
	}

}
