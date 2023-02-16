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
    void calculateGrade(ActionEvent event) {
    	double courseGrade = 0.0;
    	String projectGrade = projectGradeTextField.getText();
    	courseGrade = courseGrade + Double.parseDouble(projectGrade) *60/100;


    	double quizGrade = quizSlider.getValue();
    	courseGrade+= (quizGrade * 100/10)*0.4;

    	
    	int requiredCodingChallengesPassed = codingChallengesChoiceBox.getValue();
    	
    	int optionalCodingChallengesPassed = optionalChallengesChoiceBox.getValue();
    	courseGrade += (((optionalCodingChallengesPassed+requiredCodingChallengesPassed)*100/20)*0.6);

    	courseGradeLabel.setText(String.format("Your overall course grade is: %.2f", courseGrade));
    	
    }

}