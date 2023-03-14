package basicjava;

import java.util.ArrayList;

public class CCArrayList {
	public static int indexOfIgnoreCase(ArrayList<String> strs, String toFind) {
		int size = strs.size();

		for(int i=0; i<size;i+=1) {
			String stringInList = strs.get(i);

			String replacement = toFind;

			if (stringInList.toLowerCase().equals(replacement.toLowerCase())) {
				return i;
			}
		}
		return -1;
	}
	public static void insert(ArrayList<Double> nums, double numToInsert, int insertAtIndex) {
		// check if insert at index is a valid number
		if (insertAtIndex >= 0 && insertAtIndex <= nums.size()) {
			// .add moves everything one to the right
			nums.add(insertAtIndex, numToInsert);
		}
	}
}
