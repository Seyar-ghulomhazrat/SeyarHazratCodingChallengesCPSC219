package application;

import java.util.ArrayList;

import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class GradeCalculatorController {
	Stage applicationStage;
	double averageRequiredQuizGrade = 0.0;
	double averageOptionalQuizGrade = 0.0;


    @FXML
    private TextField projectGradeTextField;

    @FXML
    private ChoiceBox<Integer> codingChallengesChoiceBox;

    @FXML
    private ChoiceBox<Integer> optionalChallengesChoiceBox;

    @FXML
    private ChoiceBox<Integer> requiredQuizzesChoiceBox;
    
    @FXML
    private ChoiceBox<Integer> optionalQuizzesChoiceBox;
    
    @FXML
    private Label averageRequiredQuizGradeLabel;
    
    @FXML
    private Label averageOptionalQuizGradeLabel;
    
    @FXML
    private Label courseGradeLabel;
    
    @FXML
    Label projectErrorLabel;
    

    
    @FXML
    private Label projectGradeErrorLabel;

    Label requiredQuizErrorLabel = new Label();
    void calculateRequiredQuizGrades(Scene mainScene, ArrayList<TextField> quizGradeTextfield) {
    	projectGradeErrorLabel.setText("");
    	averageRequiredQuizGrade = 0.0;
    	boolean errorInQuizGrade = false;
    	double weightPerQuiz = 1.0/15;
    	for (TextField textfield : quizGradeTextfield) {
    		Grade requiredQuizGrade = new Grade(0,10,weightPerQuiz);
    		String errorMessage = requiredQuizGrade.setValue(textfield.getText());
    		requiredQuizGrade.setValue(textfield.getText());
    		if (!errorMessage.equals("")) {
    			errorInQuizGrade = true;
    			requiredQuizErrorLabel.setText(errorMessage);
    		}
        	averageRequiredQuizGrade += requiredQuizGrade.getWeightedPercentageGrade();

    	}
    	if (!errorInQuizGrade) {
        	applicationStage.setScene(mainScene);
        	averageRequiredQuizGradeLabel.setText(String.format("Average Required Quiz Grade: (percent) %.1f%%" , averageRequiredQuizGrade));
        	
    	}
    	    	
    }
    
   
    @FXML
    void getRequiredQuizGrade(ActionEvent enterReqQuizGradesevent) {
    	//store old scene in variable
    	Scene mainScene = applicationStage.getScene();
    	//number of quizzes and while loop for number of rows.
    	int numberOfQuizzes = requiredQuizzesChoiceBox.getValue();
    	int rowCounter = 0;
    	ArrayList<TextField> quizTextFields = new ArrayList<TextField>();
    	VBox allRows = new VBox();
    	Label title = new Label ("Required Quiz Grades: ");
    	allRows.getChildren().add(title);
    	while (rowCounter < numberOfQuizzes) {
    		rowCounter+=1;
    		HBox quizRow = new HBox();
        	//widgets
        	Label quizLabel = new Label("Quiz " + rowCounter +" Grade");
        	TextField quizGradeTextfield = new TextField();
        	        	
        	quizRow.getChildren().addAll(quizLabel,quizGradeTextfield);
        	quizTextFields.add(quizGradeTextfield);
        	allRows.getChildren().add(quizRow);
    	}
    	Button doneButton = new Button("Done");
    	doneButton.setOnAction(doneEvent -> calculateRequiredQuizGrades(mainScene,quizTextFields));
    	allRows.getChildren().add(doneButton);
    	
		allRows.getChildren().add(requiredQuizErrorLabel);
    	Scene quizScene = new Scene(allRows);
    	applicationStage.setScene(quizScene);
    }
    Label optionalQuizErrorLabel = new Label();
    void calculateOptionalQuizGrades(Scene mainScene, ArrayList<TextField> quizGradeTextfield) {
    	optionalQuizErrorLabel.setText("");
    	double weightPerQuiz = 1.0/5.0;
    	averageOptionalQuizGrade = 0.0;
    	boolean errorInQuizGrade = false;    	
    	for (TextField textfield : quizGradeTextfield) {
    		Grade optionalQuizGrade = new Grade(0,10,weightPerQuiz);
    		String errorMessage = optionalQuizGrade.setValue(textfield.getText());
    		if (!errorMessage.equals("")) {
    			errorInQuizGrade = true;
    			optionalQuizErrorLabel.setText(errorMessage);
    		}
    	averageOptionalQuizGrade += optionalQuizGrade.getWeightedPercentageGrade();
    	}
    	if (!errorInQuizGrade) {
    		applicationStage.setScene(mainScene);
    		averageOptionalQuizGradeLabel.setText(String.format("Average Optional Quiz Grade: %.1f%%", averageOptionalQuizGrade));
    	}
    }
    
    @FXML
    void getOptionalQuizGrade(ActionEvent enterReqQuizGradesevent) {
    	//store old scene in variable
    	Scene mainScene = applicationStage.getScene();
    	//number of quizzes and while loop for number of rows.
    	int numberOfQuizzes = optionalQuizzesChoiceBox.getValue();
    	int rowCounter = 0;
    	ArrayList<TextField> quizTextFields = new ArrayList<TextField>();
    	VBox allRows = new VBox();
    	Label title = new Label ("Optional Quiz Grades: ");
    	allRows.getChildren().add(title);
    	while (rowCounter < numberOfQuizzes) {
    		rowCounter+=1;
    		HBox quizRow = new HBox();
        	//widgets
        	Label quizLabel = new Label("Quiz " + rowCounter +" Grade");
        	TextField quizGradeTextfield = new TextField();
        	        	
        	quizRow.getChildren().addAll(quizLabel,quizGradeTextfield);
        	quizTextFields.add(quizGradeTextfield);
        	allRows.getChildren().add(quizRow);
    	}
    	Button doneButton = new Button("Done");
    	doneButton.setOnAction(doneEvent -> calculateOptionalQuizGrades(mainScene,quizTextFields));
    	allRows.getChildren().add(doneButton);
    	allRows.getChildren().add(optionalQuizErrorLabel);
    	Scene quizScene = new Scene(allRows);
    	applicationStage.setScene(quizScene);
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
    	double courseGrade = 0.0;
    	
    	Grade projectGrade = new Grade(0,100,0.5);
    	projectGradeErrorLabel.setText(projectGrade.setValue(projectGradeTextField.getText()));
    	
    	
    	double avgQuizGrade = (averageRequiredQuizGrade+averageOptionalQuizGrade)/2;
    	Grade quizGrade = new Grade(avgQuizGrade,100,0.25);
    	quizGrade.value = avgQuizGrade;

    	

    	int requiredCodingChallengesPassed = codingChallengesChoiceBox.getValue();
    	int optionalCodingChallengesPassed = optionalChallengesChoiceBox.getValue();
    	int codingChallengesPassed = requiredCodingChallengesPassed+optionalCodingChallengesPassed;
    	Grade codingChallengesGrade = new Grade(codingChallengesPassed,20,0.25);

    	
    	courseGrade = projectGrade.getWeightedPercentageGrade()+quizGrade.getWeightedPercentageGrade()+
    			codingChallengesGrade.getWeightedPercentageGrade();
    	
    	
    	//show total grade
    	courseGradeLabel.setText(String.format("Your overall course grade is: %.2f", courseGrade));
    	
    	
    }

}