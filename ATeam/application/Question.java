package application;

import java.util.List;

/**
 * Represents a single question, with members for metadata,
 * question, topic, image, choices (a list type for Choice), and
 * answer.
 * 
 * @author etges
 *
 */
public class Question {
	private String metadata;
	private String question;
	private String topic;
	private String image;
	private List<Choice> choices;
	private String answer;
	
	public Question(String metadata, String question, String topic, String image, List<Choice> choices, String answer) {
		this.metadata = metadata;
		this.question = question;
		this.topic = topic;
		this.image = image;
		this.choices = choices;
		this.answer = answer;
	}
	
	public String getQuestion() {
		return this.question;
	}
	
	public List<Choice> getChoices() {
		return this.choices;
	}
	
	public String getAnswer() {
		return this.answer;
	}
	
	public String getMetadata() {
		return this.metadata;
	}
	
	public String getTopic() {
		return this.topic;
	}
	
	public String getImage() {
		return this.image;
	}
}
