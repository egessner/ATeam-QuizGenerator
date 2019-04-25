//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title:           Quiz Generator
// Files:           Main.java
// Due:				Thusday, Apr. 25, 2019 10pm
// Course:          CS 400 Spring 2019
//
// Team:          	ATeam 4 (Sarah Bangen, Paul Cary, Erik Gessner, Robert Niemann)
// Email:           rcary2@wisc.edu
// Lecturer's Name: Debra Deppeler
//
///////////////////////////// CREDIT OUTSIDE HELP /////////////////////////////
//
// Students who get help from sources other than their partner must fully
// acknowledge and credit those sources of help here.  Instructors and TAs do
// not need to be credited here, but tutors, friends, relatives, room mates,
// strangers, and others do.  If you received no outside help from either type
//  of source, then please explicitly indicate NONE.
//
// Persons:         NONE
// Online Sources:  
//	1) CSS Border Elements --.getStyleClass().add("class"):
//		//https://stackoverflow.com/questions/27712213/how-do-i-make-a-simple-solid-border-around-a-flowpane-in-javafx
//  2) Max/Min/Pref Sizing
//		//https://docs.oracle.com/javafx/2/layout/size_align.htm
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////

package ateam_project;

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
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;


public class Main extends Application {
		QuestionDatabase questionDB;
		List<Question> questions;
		Question currQuestion;
		int currQuestionNum;
		int totalQuestionNum;
		int numIncorrect;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		questionDB = new QuestionDatabase();
		
		
		//Create scene instance
		Scene mainScene = mainScene(515,305);
		mainScene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		
		primaryStage.setTitle("Quiz Generator");
		primaryStage.setScene(mainScene);
		primaryStage.show();
		
	}
	
	
	//Move start methods here
	private Scene mainScene(Integer width, Integer height) {
		//<... Quiz Setup, Quiz Results, Save Quiz button
				VBox leftMain = new VBox(); 
				
				//Inner Left VBox Top - Quiz Setup
				VBox quizSetupBox = new VBox();
				//Quiz Setup Label
				Label quizSetupLabel = new Label("Quiz Setup");
				quizSetupLabel.setFont(new Font("Arial", 20));
				//LoadQuizFromJSON Button
				Button loadQuizFromJSONButton = new Button("Load Questions from JSON");
				loadQuizFromJSONButton.setPrefWidth(165);
				//Add New Question Button
				Button addNewQuestionButton = new Button("Add New Question");
				addNewQuestionButton.setPrefWidth(165);
				//Status Box -- Currently Hard-coded for Milestone 2
				//Integer nQs = questionDB.getNumQuestions();
				Integer nQs = 0;
				Text totalQuestions = new Text("Questions Available:\t"+String.valueOf(nQs));
				Integer nTs = 6; 
				Text totalTopics = new Text("Topics Available:\t\t"+String.valueOf(nTs));
				
				//Add Nodes --Can add to List, then .addAll()
				// ...but this will help debug for now.
				quizSetupBox.getChildren().add(quizSetupLabel);
				quizSetupBox.getChildren().add(loadQuizFromJSONButton);
				quizSetupBox.getChildren().add(addNewQuestionButton);
				quizSetupBox.getChildren().add(totalQuestions);
				quizSetupBox.getChildren().add(totalTopics);
				quizSetupBox.getStyleClass().add("pane");
				quizSetupBox.setSpacing(5);
				quizSetupBox.setPadding(new Insets(5,5,5,5));
				
				//Inner Left VBox Bottom - Quiz Results
				VBox quizResultsBox = new VBox();
				//Quiz Results Label
				Label quizResultsLabel = new Label("Quiz Results");
				quizResultsLabel.setFont(new Font("Arial", 20));
				Text nCorrectText = new Text("Number Correct:\t\t0");
				Text nAnsweredText = new Text("Number Answered:\t\t0");
				Text percentCorrectText = new Text("Percent Correct: \t\t0%");
				
				quizResultsBox.getChildren().add(quizResultsLabel);
				quizResultsBox.getChildren().add(nCorrectText);
				quizResultsBox.getChildren().add(nAnsweredText);
				quizResultsBox.getChildren().add(percentCorrectText);
				quizResultsBox.getStyleClass().add("pane");
				quizResultsBox.setSpacing(5);
				quizResultsBox.setPadding(new Insets(5,5,10,5));
				
				//Build leftMain VBox
				leftMain.getChildren().add(quizSetupBox);
				leftMain.getChildren().add(quizResultsBox);
				leftMain.setSpacing(5);
				leftMain.setPadding(new Insets(10,5,10,10));
				
				// ...> Create PracticeQuiz Box
				VBox rightMain = new VBox();  
				
				VBox practiceQuizBox = new VBox();
				Label practiceQuizLabel = new Label("Create Practice Quiz");
				practiceQuizLabel.setFont(new Font("Arial", 20));
				Text selectTopicsText = new Text("Select Topics:");
				selectTopicsText.setFont(new Font("Arial", 16));
				//Hard-coded topics list for Milestone 1
				List<String> topicList = Arrays.asList("Topic1", "Topic2", "Topic3", "Topic4", "Topic5", "Topic6");
				ScrollPane topicsPane = new ScrollPane();
				VBox topicContentVBox = new VBox();
				//Check if there are topics
				if (nTs == 0) { //No topics, explain why Pane is empty
					//Fill with "Please add Questions to populate topics list"
					Label noTopicsLabel = new Label("Please load or add Questions to populate topics list");
					noTopicsLabel.setWrapText(true);
					noTopicsLabel.setStyle("-fx-text-fill: darkgray");
					topicsPane.setContent(noTopicsLabel);
				} else { //Fill Pane with select-able topics
					for (String topic : topicList) {
						topicContentVBox.getChildren().add(createTopicBox(topic));
					}
					topicsPane.setContent(topicContentVBox);					
				}
				topicsPane.setPadding(new Insets(0,5,0,5));
				
				Label nQuestionsLabel = new Label("Number of Questions:");
				nQuestionsLabel.setPadding(new Insets(5,0,0,0));
				TextField nQsTextArea = new TextField("Enter Number");
				HBox nQuestionEntryBox = new HBox(nQuestionsLabel, nQsTextArea);
				nQuestionEntryBox.setSpacing(10);
				
				Text practiceQuizNote = new Text("Note: If there is an insufficient number of questions in the selected topic(s), questions will be randomly selected from other topics.");
				practiceQuizNote.setWrappingWidth(275);
				//practiceQuizNote.setWrappingWidth(nQuestionsLabel.getWidth());
				//practiceQuizNote.maxWidth(nQuestionEntryBox.getWidth());
				
				Button generateQuizButton = new Button("Start Practice Quiz");
				//https://docs.oracle.com/javafx/2/layout/size_align.htm
				//Careful this is the Maximum from any element.
				generateQuizButton.setMaxWidth(Double.MAX_VALUE);
				
				practiceQuizBox.getChildren().add(practiceQuizLabel);
				practiceQuizBox.getChildren().add(selectTopicsText);
				practiceQuizBox.getChildren().add(topicsPane);
				practiceQuizBox.getChildren().add(nQuestionEntryBox);
				practiceQuizBox.getChildren().add(practiceQuizNote);
				practiceQuizBox.getChildren().add(generateQuizButton);
				practiceQuizBox.getStyleClass().add("pane");
				practiceQuizBox.setSpacing(5);
				practiceQuizBox.setPadding(new Insets(5,5,5,5));
				
				//SaveButton below Quiz Results
				Button saveQuizToJSONButton = new Button("Save Questions to JSON");
				saveQuizToJSONButton.setPrefWidth(165);
				BorderPane saveBox = new BorderPane();
				saveBox.setLeft(saveQuizToJSONButton);
				saveBox.setPadding(new Insets(0,0,0,5));
				
				//Button below practice quiz box
				Button exitButton = new Button("Exit");
				exitButton.setPrefSize(100, 20);
				BorderPane exitBox = new BorderPane();
				exitBox.setRight(exitButton);
				exitBox.setPadding(new Insets(0,5,0,0));
				
				//Add to rightMain
				rightMain.getChildren().add(practiceQuizBox);
				rightMain.setSpacing(5);
				rightMain.setPadding(new Insets(10,10,5,5));
				
				//Build upper and lower HBoxes
				//HBox upper = new HBox(leftMain,rightMain);
				BorderPane upper = new BorderPane();
				upper.setLeft(leftMain);
				upper.setRight(rightMain);
				BorderPane lower = new BorderPane();
				lower.setRight(exitBox);
				lower.setLeft(saveBox);
				lower.setPadding(new Insets(0,10,10,10));
				//Build root pane
				VBox root = new VBox(upper,lower);
				
				//Create Scene
				Scene scene = new Scene(root,width,height);
				
		return scene;
		
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
