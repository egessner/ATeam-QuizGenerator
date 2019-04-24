package ateam_project;

import javafx.scene.Node;

/**
 * An interface for classes which wrap around the JavaFX
 * Node class. The intent is to abstract out classes which can
 * internally contain complex JavaFX entities, but could be
 * represented externally by a single Node object, allowing
 * the node to be contained inside other JavaFX containers
 * without exposing any internal details.
 * 
 * @author 
 *
 */
public interface NodeWrapperADT {
	Node getNode();
}
