package ateam_project;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import ateam_project.Question;
import ateam_project.QuestionDatabase;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.layout.Priority;


public class Main extends Application {
		QuestionDatabase questionDB;
		List<Question> questions;
		Question currQuestion;
		int currQuestionNum;
		int totalQuestionNum;
		int numIncorrect;
	
	
	
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		//<... Quiz Setup, Quiz Results, Save Quiz button
		VBox leftMain = new VBox(); 
		
		//Inner VBox Top - Quiz Setup
		VBox quizSetupBox = new VBox();
		//Quiz Setup Label
		Label quizSetupLabel = new Label("Quiz Setup");
		//LoadQuizFromJSON Button
		Button loadQuizFromJSONButton = new Button("Load Quiz from JSON");
		//Add New Question Button
		Button addNewQuestionButton = new Button("Add New Question");
		//Add Nodes --Can add to List, then .addAll()
		// ...but this will help debug for now.
		quizSetupBox.getChildren().add(quizSetupLabel);
		quizSetupBox.getChildren().add(loadQuizFromJSONButton);
		quizSetupBox.getChildren().add(addNewQuestionButton);
		quizSetupBox.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
		quizSetupBox.setSpacing(5);
		//Inner VBox Bottom - Quiz Results
		VBox quizResultsBox = new VBox();
		//Quiz Results Label
		Label quizResultsLabel = new Label("Quiz Results:");
		Text nCorrectText = new Text("Number Correct: ");
		Text nAnsweredText = new Text("Number Answered: ");
		Text percentCorrectText = new Text("Percent Correct: \t%");
		//
		quizResultsBox.getChildren().add(quizResultsLabel);
		quizResultsBox.getChildren().add(nCorrectText);
		quizResultsBox.getChildren().add(nAnsweredText);
		quizResultsBox.getChildren().add(percentCorrectText);
		quizResultsBox.setSpacing(5);
		quizResultsBox.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
		//https://stackoverflow.com/questions/27712213/how-do-i-make-a-simple-solid-border-around-a-flowpane-in-javafx
		//quizResultsBox.getStyleClass().add("pane");
		//SaveButton
		Button saveQuizToJSONButton = new Button("Save Quiz to JSON");
		
		//Build leftMain VBox
		leftMain.getChildren().add(quizSetupBox);
		leftMain.getChildren().add(quizResultsBox);
		leftMain.getChildren().add(saveQuizToJSONButton);
		leftMain.setSpacing(20);
		
		// ...> PracticeQuiz Box, Exit button
		VBox rightMain = new VBox();  
		
		VBox practiceQuizBox = new VBox();
		Label practiceQuizLabel = new Label("Practice Quiz");
		Text selectTopicsText = new Text("Select Topics");
		List<String> topicList = Arrays.asList("Topic1", "Topic2", "Topic3", "Topic4", "Topic5");
		ScrollPane topicsPane = new ScrollPane();
		topicsPane.setPrefSize(120, 50);
		//topicsPane.setContent();
		VBox topicContentVBox = new VBox();
		for (String topic : topicList) {
			topicContentVBox.getChildren().add(createTopicBox(topic));
		}
		topicsPane.setContent(topicContentVBox);
		topicsPane.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
		Label nQuestionsLabel = new Label("Number of Questions");
		TextArea nQsTextArea = new TextArea("Enter Number");
		Button generateQuizButton = new Button("Generate Quiz");
		
		practiceQuizBox.getChildren().add(practiceQuizLabel);
		practiceQuizBox.getChildren().add(selectTopicsText);
		practiceQuizBox.getChildren().add(topicsPane);
		practiceQuizBox.getChildren().add(nQuestionsLabel);
		practiceQuizBox.getChildren().add(nQsTextArea);
		practiceQuizBox.getChildren().add(generateQuizButton);
		practiceQuizBox.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
		
		//Button below practice quiz box
		Button exitButton = new Button("Exit");
		
		//Add to rightMain
		rightMain.getChildren().add(practiceQuizBox);
		rightMain.getChildren().add(exitButton);

		
		//Build root pane
		BorderPane root = new BorderPane();
		root.setLeft(leftMain);
		root.setRight(rightMain);
		
		//Create scene instance
		Scene mainScene = new Scene(root,800,600);
		mainScene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setTitle("Quiz Generator");
		primaryStage.setScene(mainScene);
		primaryStage.show();
		
	}
	
	
	private HBox createTopicBox(String topic) {
		CheckBox topicCheckBox = new CheckBox();
		Text topicText = new Text(topic);
		HBox topicBox = new HBox(topicCheckBox, topicText);
		topicBox.setSpacing(30);
		
		return topicBox;
	}
	
	 
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

}
