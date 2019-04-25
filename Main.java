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
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
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
		quizSetupLabel.setFont(new Font("Arial", 20));
		//LoadQuizFromJSON Button
		Button loadQuizFromJSONButton = new Button("Load Quiz from JSON");
		//Add New Question Button
		Button addNewQuestionButton = new Button("Add New Question");
		//Add Nodes --Can add to List, then .addAll()
		// ...but this will help debug for now.
		quizSetupBox.getChildren().add(quizSetupLabel);
		quizSetupBox.getChildren().add(loadQuizFromJSONButton);
		quizSetupBox.getChildren().add(addNewQuestionButton);
		quizSetupBox.getStyleClass().add("pane");
		quizSetupBox.setSpacing(5);
		//Inner VBox Bottom - Quiz Results
		VBox quizResultsBox = new VBox();
		//Quiz Results Label
		Label quizResultsLabel = new Label("Quiz Results:");
		quizResultsLabel.setFont(new Font("Arial", 20));
		Text nCorrectText = new Text("Number Correct: ");
		Text nAnsweredText = new Text("Number Answered: ");
		Text percentCorrectText = new Text("Percent Correct: \t%");
		//
		quizResultsBox.getChildren().add(quizResultsLabel);
		quizResultsBox.getChildren().add(nCorrectText);
		quizResultsBox.getChildren().add(nAnsweredText);
		quizResultsBox.getChildren().add(percentCorrectText);
		quizResultsBox.setSpacing(5);
		//quizResultsBox.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
		//https://stackoverflow.com/questions/27712213/how-do-i-make-a-simple-solid-border-around-a-flowpane-in-javafx
		quizResultsBox.getStyleClass().add("pane");
		//SaveButton
		Button saveQuizToJSONButton = new Button("Save Quiz to JSON");
		
		//Build leftMain VBox
		leftMain.getChildren().add(quizSetupBox);
		leftMain.getChildren().add(quizResultsBox);
		leftMain.getChildren().add(saveQuizToJSONButton);
		//leftMain.setSpacing(20);
		leftMain.setSpacing(20);
		leftMain.setPadding(new Insets(20,20,20,20));
		
		// ...> PracticeQuiz Box, Exit button
		VBox rightMain = new VBox();  
		
		VBox practiceQuizBox = new VBox();
		Label practiceQuizLabel = new Label("Create Practice Quiz");
		practiceQuizLabel.setFont(new Font("Arial", 20));
		Text selectTopicsText = new Text("Select Topics");
		List<String> topicList = Arrays.asList("Topic1", "Topic2", "Topic3", "Topic4", "Topic5");
		ScrollPane topicsPane = new ScrollPane();
		//topicsPane.setPrefSize(120, 50);
		//topicsPane.setContent();
		VBox topicContentVBox = new VBox();
		//Fill with "Please add Questions to populate topics list"
		for (String topic : topicList) {
			topicContentVBox.getChildren().add(createTopicBox(topic));
		}
		topicsPane.setContent(topicContentVBox);
		topicsPane.getStyleClass().add("pane");
		
		Label nQuestionsLabel = new Label("Number of Questions");
		TextField nQsTextArea = new TextField("Enter Number");
		HBox nQuestionEntryBox = new HBox(nQuestionsLabel, nQsTextArea);
		nQuestionEntryBox.setSpacing(10);
		Button generateQuizButton = new Button("Start Practice Quiz");
		
		practiceQuizBox.getChildren().add(practiceQuizLabel);
		practiceQuizBox.getChildren().add(selectTopicsText);
		practiceQuizBox.getChildren().add(topicsPane);
		practiceQuizBox.getChildren().add(nQuestionEntryBox);
		//practiceQuizBox.getChildren().add(nQsTextArea);
		practiceQuizBox.getChildren().add(generateQuizButton);
		practiceQuizBox.getStyleClass().add("pane");
		practiceQuizBox.setSpacing(5);
		
		//Button below practice quiz box
		Button exitButton = new Button("Exit");
		exitButton.setPrefSize(100, 20);
		//HBox exitBox = new HBox(exitButton);
		//exitBox.setPadding(new Insets(0,0,0,178));
		BorderPane exitBox = new BorderPane();
		exitBox.setRight(exitButton);
		//exitButton.setPadding(new Insets(0,0,0,50));
		
		//Add to rightMain
		rightMain.getChildren().add(practiceQuizBox);
		rightMain.getChildren().add(exitBox);
		rightMain.setSpacing(20);
		rightMain.setPadding(new Insets(20,20,20,20));
		
		//Build root pane
		HBox root = new HBox(leftMain,rightMain);
		//root.setSpacing(30);
		//root.setLeft(leftMain);
		//root.setRight(rightMain);
		
		//Create scene instance
		Scene mainScene = new Scene(root,500,275);
		mainScene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setTitle("Quiz Generator");
		primaryStage.setScene(mainScene);
		primaryStage.show();
		
	}
	
	
	//Move start methods here
	private Scene mainScene() {
		return null;
		
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
