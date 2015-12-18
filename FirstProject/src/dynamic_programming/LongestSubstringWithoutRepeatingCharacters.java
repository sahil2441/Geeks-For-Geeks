package dynamic_programming;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {

	public static void main(String[] args) {
		String s = "geeksforgexyzqw";
		System.out.println(longestSubstring(s));
	}

	private static int longestSubstring(String s) {
		int max = 0;
		int curr_max = 0;
		Map<Character, Integer> map = new HashMap<Character, Integer>();

		for (int i = 0; i < s.length(); i++) {
			if (map.get(s.charAt(i)) != null) {
				int lastIndex = map.get(s.charAt(i));
				curr_max = i - lastIndex;
			} else {
				curr_max += 1;
			}
			max = curr_max > max ? curr_max : max;
			map.put(s.charAt(i), i);
		}
		return max;
	}

}
