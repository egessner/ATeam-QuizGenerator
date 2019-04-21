package application;

/**
 * Contains one of the several choices in a question.
 * 
 * @author 
 *
 */
public class Choice {
	private boolean isCorrect;
	private String choice;
	
	public Choice(boolean isCorrect, String choice) {
		this.isCorrect = isCorrect;
		this.choice = choice;
	}
	
	public String getChoice() {
		return this.choice;
	}
	
	public boolean getIsCorrect() {
		return this.isCorrect;
	}
}
