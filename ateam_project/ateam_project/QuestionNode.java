package ateam_project;

import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;

/**
 * JavaFX elements for displaying a single Question to the
 * user.
 * 
 * @author
 *
 */
public class QuestionNode implements NodeWrapperADT{
	private VBox node;
	private ToggleGroup choices;
	
	public QuestionNode(Question question) {
		
	}
	
	public VBox getNode() {
		return this.node;
	}
	
	public ToggleGroup getChoices() {
		return this.choices;
	}
}
