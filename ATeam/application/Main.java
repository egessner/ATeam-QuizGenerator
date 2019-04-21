package application;
	

import java.util.List;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;


public class Main extends Application {
	QuestionDatabase questionDB;
	List<Question> questions;
	Question currQuestion;
	int currQuestionNum;
	int totalQuestionNum;
	int numIncorrect;
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(displayAddQuestionForm( primaryStage));
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void setup() {
		
	}
	
	public Scene displayAddQuestionForm( Stage primaryStage) {
		BorderPane root = new BorderPane();
		Scene question = new Scene(root, 400, 400);
		
		Label AddNewQuestion = new Label("Add New Question");
		HBox center = new HBox();
		Button AddQuestion = new Button("Add New Question");
		
		Label topicLabel = new Label("Topic:");
		TextArea topicText = new TextArea("enter topic");
		topicText.setMaxSize(200, 20);
		HBox topic = new HBox(topicLabel, topicText);
		topic.setSpacing(100);
		topic.setMaxSize(400, 20);
		
		
		
		
		
		
		root.setCenter(createAnswerBox("test"));
		root.setBottom(AddQuestion);
		root.setTop(AddNewQuestion);
		return question;
	}
	
	private HBox createAnswerBox(String label) {
		Label answerLabel = new Label(label);
		CheckBox answerCheckB = new CheckBox();
		TextArea answerTextA = new TextArea("enter " + label + " text");
		answerTextA.setMinSize(100, 24);
		answerTextA.setMaxSize(300, 25);
		
		HBox answer = new HBox(answerLabel, answerCheckB, answerTextA);
		answer.setSpacing(30);
		answer.setMaxSize(400, 20);
		
		return answer;
	}
	
	public void displayQuiz() {
		
	}
	
	public void displayQuestion() {
		
	}
	
	public void displaySubmit(QuestionNode node) {
		
	}
	
	public void displayResults() {
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
