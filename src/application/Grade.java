package application;

public class Grade {
	double value;
	int maxValue = 100;
	double weight;

	/**
	 * This method takes three parameters and sets them equal to the value, maximum value, and weight
	 * of the grade.
	 * @param gradeValue set equal to value of the grade
	 * @param maxPossibleValue set equal to maximum possible grade of that component
	 * @param weightTowardsCourseGrade set equal to Weight of component
	 * @return null
	 */
	Grade(double gradeValue, int maxPossibleValue, double weightTowardsCourseGrade){
		value = gradeValue;
		maxValue = maxPossibleValue;
		weight = weightTowardsCourseGrade;
	}
	/** When called, this method will calculate percentage grade of any component.
	 * Will multiply the value by 100 times the weight of the component and divide by its maximum
	 * possible value.
	 * @return returns percent value of graded component
	 */
	double getWeightedPercentageGrade() {
		return value*100*weight/maxValue;
	}
	/**
	 * This method will set the value of the graded component to either an error message (if invalid) or 
	 * the numeric value of the grade.
	 * @param valueAsString this parameter passed in as a string initially and is checked for negative values,
	 * multiple decimals, or invalid grade values.
	 * @return Returns either an error message or grade value of component
	 */
	String setValue(String valueAsString) {
	//Checking that the user entered a valid numeric value
	boolean validGrade = true;
	//counts the amount of times a decimal has been inputed (One decimal input is allowed)
	int decimals = 0;
	String errorMessage = "";
	for (char c : valueAsString.toCharArray()){
		//checking for multiple decimals or other non digit characters
		if (!Character.isDigit(c)) {
			if (c == '.') {
				decimals+=1;
				if (decimals>1) {
					validGrade = false;
					errorMessage =("Do not incude multiple decimals.");
				}
			}
			else {
				validGrade = false;
				errorMessage = String.format("Do not use '%c' in a grade value. Make sure to "
						+ "enter a number.",c);
		}
		}
	}	
	if (validGrade) {
		value = Double.parseDouble(valueAsString);
	}
	// Check if project grade is a valid percentage grade and if not reseting project grade to 0.
	if (value<0 || value>maxValue) {
		errorMessage = String.format("Grade should be between 0 and %d.", maxValue);
		value = 0;
	}
	return errorMessage;
}}
