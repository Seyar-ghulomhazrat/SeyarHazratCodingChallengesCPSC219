package basicjava;

public class CCStringsIfAndWhile {

	public static boolean isDigit(char c) {
	    boolean isDig = false;
	    // setting a character equal to zero and checking if it equals input character. 
	    char dig = '0';
	    //Iterating through all dig.
	    while (dig <= '9') {
	        if (c == dig) {
	            isDig = true;
	            break;
	        }
	        dig+=1;
	 }
	    return isDig;
	}

	public static int count(String str, String chars) {
	    int sameCharacterCount = 0;
	    //start count at zero and loop through first input
	    for (int i = 0; i < str.length();) {
	        char c = str.charAt(i);
	        boolean sameChar = false;
	        //loop through second input
	        for (int j = 0; j < chars.length();) {
	        	//check if both iterations are equal to each other. 
	            if (c == chars.charAt(j)) {
	                sameChar = true;
	                break;
	            }
	            j+=1;
	        }
	        if (sameChar == true) {
	            sameCharacterCount+=1;
	        }
	        i+=1;
	    }
	    return sameCharacterCount;
	}


	public static int smallestDigit(int i) {
		// TODO Auto-generated method stub
		return 0;
	}

}
