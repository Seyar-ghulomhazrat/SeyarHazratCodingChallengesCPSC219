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

	public static int count(String string, String string2) {
		// TODO Auto-generated method stub
		return 0;
	}

	public static int smallestDigit(int i) {
		// TODO Auto-generated method stub
		return 0;
	}

}
