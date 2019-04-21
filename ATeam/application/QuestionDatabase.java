package application;

import java.io.File;
import java.util.List;
import java.util.Map;

import javafx.collections.ObservableList;

/**
 * Contains all questions (of type Question) from .json files
 * an added manually by user.
 * 
 * @author etges
 *
 */
public class QuestionDatabase implements QuestionDatabaseADT{
	private Map<String, List<Question>> topics;
	
	public QuestionDatabase() {
		
	}
	
	public void addQuestion(String topic, Question question) {
		
	}
	
	public int getNumQuestions() {
		return 0;
	}
	
	public void saveQuestionsToJSON(File file) {
		
	}
	
	public List<Question> getQuestions(String topic) {
		return null;
	}
	
	public void loadQuestionsFromJSON(File file) {
		
	}
	
	public ObservableList<String> getTopics() {
		return null;
	}
}
