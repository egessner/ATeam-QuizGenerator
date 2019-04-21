package application;

import java.io.File;
import java.util.List;

import javafx.collections.ObservableList;

/**
 * Contains all questions loaded from .json files and added
 * manually through Add Question Form.
 * 
 * @author
 *
 */
public interface QuestionDatabaseADT {
	
	void addQuestion(String topic, Question question);
	
	void saveQuestionsToJSON(File file);
	
	List<Question> getQuestions(String topic);
	
	void loadQuestionsFromJSON(File file);
	
	ObservableList<String> getTopics();
}
