package basicjava;

import java.util.ArrayList;

public class RecursionExercises {

// function 1: countDigits
// takes an int as an argument an returns the number of digits in it
  public static int countDigits(int x) {
	// if x is negative, make it positive 
	if(x<0) {
		x*=-1;
	}
	
	if (x>=10) {
		return countDigits(x/10)+1;
	}
	
	else {
		return 1;
	}}


//function 2: addDigits
//takes an int as an argument and returns sum of the digits in that argument
  public static int addDigits(int x) {
	
	//if x is negative, make it positive  
	if (x<0) {
		x*=-1;
	}

	if (x>=10) {
		return addDigits(x/10)+(x%10); //x%10 is for the last digit and x/10 is removing the last digit
	}
	//if x only has one digit, return x
	else{
		return x;
	}
  }

  // function 3: sum
  // returns the sum of numbers betweeen 2 arguments
  public static int sum(int sumFrom, int sumTo) {
	//ensure numbers in range are valid
	//cant be negatives
	if (sumFrom<0) {
		return 0;
	}
	if (sumTo<0) {
		return 0;
	}
	//sumFrom cannot be greater than sumTo
	if (sumFrom>sumTo) {
		return 0;
	}
	  
    else {
    // sumFrom because the function is inclusive then recurring over with the next number	
      return sumFrom + sum(sumFrom + 1, sumTo);
    }
  }

  // function 4: sumEvenNumbers
  //calculates the num of even numbers between 0 and argument (inclusive)
  public static int sumEvenNumbers(int x) {
	//if x is negative return 0
	  if (x<0) {
		return 0;
	}
	// checking if number is even initially
	boolean evenNum = false;
	if (x%2 ==0) {
		evenNum = true;
	}
	
	if (evenNum) {
		// if number is even: add it, then go to the next even number
		return sumEvenNumbers(x-2)+x;
	}
	
	else {
		// if number is not initially even, make it even
		return sumEvenNumbers(x-1);
	}
	
  }
  
  
  // function 5: sumOfMultiple
  // this function takes list as an argument and returns sum of all numbers in list that are multiple 5
  public static int sumOfMultiple(ArrayList<Integer> list) {
	// checking if list is initially null  
	if(list == null) {
		return 0;
	}
	// check if list is empty
	boolean listIsEmpty = false;
	if (list.isEmpty()) {
		listIsEmpty = true;
	}
	if(listIsEmpty) {
		return 0;
	}
	
	else {
		//going through first element of list and recurring over it 
		int y = list.remove(0);
		if(y%5 ==0) {
			return y+sumOfMultiple(list);
		}
		else {
			return sumOfMultiple(list);
		}
	}
  }
  
  //function #6
  //takes string as an argument and returns number of vowels in argument
  public static int countVowels(String x) {
	  // if lists are empty or null return 0
	  	if(x ==null) {
	  		return 0;
	  	}
	  	
	  	if(x.length()==0) {
	  		return 0;
	  	}
	  	
	  	
	  	else {
	  		char character = x.charAt(0);
	  		int count = countVowels(x.substring(1));
	  		if (character == 'a' ||character == 'A'||character == 'e'||character == 'E'
	  				||character == 'i'||character == 'I'||character == 'o'||character == 'O'
	  				||character == 'u'||character == 'U') {
	  			return count+1;
	  		}
	  		else {
	  			return count;
	  		}}}



//function #7
//removes vowels from an argument
  public static String removeVowels(String x) {
	    if (x == null) {
	        return null;
	    }
	    String vowels = "aeiouAEIOU";
	    String result = x.replaceAll("[" + vowels + "]", "");
	    return result;
	}}



