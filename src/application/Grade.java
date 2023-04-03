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
	Grade(String stringValue, int maximumValue, double weightInOverallGrade){
		maxValue = maximumValue;
		weight = weightInOverallGrade;
		
		try {
			value = Double.parseDouble(stringValue);
			if (value>maxValue || value<0) {
				throw new InvalidGradeException(String.format("Grade should be between 0 and %d.", maxValue));
			}
		}
		catch (NumberFormatException e) {
			 throw new InvalidGradeException(String.format("Invalid grade value: %s. Please enter a number.", stringValue));
		}
	}
	/** When called, this method will calculate percentage grade of any component.
	 * Will multiply the value by 100 times the weight of the component and divide by its maximum
	 * possible value.
	 * @return returns percent value of graded component
	 */
	double getWeightedPercentageGrade() {
		return value*100*weight/maxValue;
	}
}
