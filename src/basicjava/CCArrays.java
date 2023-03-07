package basicjava;

import java.util.Arrays;

public class CCArrays {
	public static void replace(char[] charArray, char toReplace, char replaceWith) {
		int length = charArray.length;
		for (int i = 0; i<length;) {
			char charArrayLowered = Character.toLowerCase(charArray[i]);
			char toReplaceLowered = Character.toLowerCase(toReplace);
			if (charArrayLowered == toReplaceLowered) {
				charArray[i] = replaceWith;
			}
			i+=1;
		}
	}
	public static void sortAlphabetic(String[] strArray) {

		Arrays.sort(strArray, String.CASE_INSENSITIVE_ORDER);
	}
}
