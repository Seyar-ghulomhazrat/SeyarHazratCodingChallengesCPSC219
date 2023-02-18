package application;

import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class GradeCalculatorController {

    @FXML
    private TextField projectGradeTextField;

    @FXML
    private ChoiceBox<Integer> codingChallengesChoiceBox;

    @FXML
    private ChoiceBox<Integer> optionalChallengesChoiceBox;

    @FXML
    private Slider quizSlider;
    
    @FXML
    private Label courseGradeLabel;
    
    @FXML
    Label projectErrorLabel;
    
    @FXML
    private Label projectGradeErrorLabel;
    /**
     * Checks if the value provided is a valid project grade. A project grade must be numeric and a percentage grade.
     * A percentage grade must be between 0 and 100. If valid, the equivalent double is returned. If not, this method
     * returns 0. 
     * @param ValueEntered the value entered as the project grade
     * @return the double value of valueEntered if it is numeric and a percentage and 0 otherwise.
     */
    double getProjectGrade(String ValueEntered) {
    	//Checking that the user entered a valid numeric value
    	boolean validProjectGrade = true;
    	//counts the amount of times a decimal has been inputed (One decimal input is allowed)
		int decimals = 0;
    	for (char c : ValueEntered.toCharArray()){
    		//checking for multiple decimals or other non digit characters
    		if (!Character.isDigit(c)) {
    			if (c == '.') {
    				decimals+=1;
    				if (decimals>1) {
    					validProjectGrade = false;
    					projectGradeErrorLabel.setText("Do not incude multiple decimals.");
    				}
    			}
    			else {
    				validProjectGrade = false;
    				projectGradeErrorLabel.setText("Do not incude the character '" + c+"' "
    						+ "\nProject Grade entered should be a number");
    		}
    		}
    	}
    	// Default project grade to 0. if valid number entered, convert user input to floating point number. 
    	double projectGrade = 0;
    	if (validProjectGrade) {
    		projectGrade = Double.parseDouble(ValueEntered);
    	}
    	// Check if project grade is a valid percentage grade and if not reseting project grade to 0.
    	if (projectGrade<0 || projectGrade>100) {
    		projectGradeErrorLabel.setText("Project Grade should be between 0% and 100%. \nInvalid Project Grade: "+
    	projectGrade);
    		projectGrade = 0;
    	}
    	return projectGrade;
    }
    /**
     * Sets initial course grade to 0. Gets a number of CC's passed, grade of all quizzes, and
     * percentage grade of project (from getProjectGrade). Then weighs all the information based off course outline weighing
     * and adds them together. Finally, displays overall course grade to user.
     * @param event Event that triggered calculation of course grade
     */
    @FXML
    void calculateGrade(ActionEvent event) {
    	//set error to an empty string initially
    	projectGradeErrorLabel.setText("");
    	
    	//set grade to zero
    	double courseGrade = 0.0;
    	String projectValueEntered = projectGradeTextField.getText();
    	
    	//add project grade
    	double projectGrade = getProjectGrade(projectValueEntered);
    	courseGrade = courseGrade + (projectGrade)*0.5;
    	
    	//add quiz grade
    	double quizGrade = quizSlider.getValue();
    	courseGrade+= (quizGrade * 100/10)*0.25;
    	
    	//add cc grades
    	int requiredCodingChallengesPassed = codingChallengesChoiceBox.getValue();
    	int optionalCodingChallengesPassed = optionalChallengesChoiceBox.getValue();
    	courseGrade += (((optionalCodingChallengesPassed+requiredCodingChallengesPassed)*100/20)*0.25);
    	
    	//show total grade
    	courseGradeLabel.setText(String.format("Your overall course grade is: %.2f", courseGrade));
    	
    }

}