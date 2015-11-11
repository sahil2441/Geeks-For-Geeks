package dynamic_programming;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {

	public static void main(String[] args) {
		String s = "geekesfoergeeks";
		System.out.println(longestSubstring(s));
	}

	private static int longestSubstring(String s) {
		int max = 0;
		int curr_max = 0;
		Map<Character, Boolean> map = new HashMap<Character, Boolean>();

		for (int i = 0; i < s.length(); i++) {
			if (map.get(s.charAt(i)) != null) {
				map = new HashMap<Character, Boolean>();
				curr_max = 1;
			} else {
				curr_max += 1;
				max = curr_max > max ? curr_max : max;
			}
			map.put(s.charAt(i), true);
		}
		return max;
	}

}
