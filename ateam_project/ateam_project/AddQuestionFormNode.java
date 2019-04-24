package ateam_project;

import java.util.List;

import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;

/**
 * JavaFX elements for displaying a form to add a new
 * question to the database. User is required to input all
 * information required to create a new Question object and
 * add it to the database.
 * 
 * @author
 *
 */
public class AddQuestionFormNode implements NodeWrapperADT{
	private List<TextField> choiceTexts;
	private List<ToggleGroup> choiceGroups;
	private VBox form;
	
	public AddQuestionFormNode() {
		
	}
	
	public TextField getMetadata() {
		return null;
	}
	
	public TextField getQuestion() {
		return null;
	}
	
	public TextField getTopic() {
		return null;
	}
	
	public TextField getImage() {
		return null;
	}
	
	public List<TextField> getChoiceTexts() {
		return null;
	}
	
	public VBox getNode() {
		return null;
	}
	
	public List<TextField> getChoiceGroups() {
		return null;
	}
}
