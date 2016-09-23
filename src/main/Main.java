/**
 * Packages are like namespaces.
 */
package main;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

// YOUR MISSION, SHOULD YOU CHOOSE TO ACCEPT IT                                  STOP
// CREATE A TEXT FILE NAMED AFTER YOU IN THE SRC FOLDER AND COMMIT IT            STOP
// THEN STUDY THE THREE CODE FILES IN THIS DEMO PROJECT
// AND EDIT IT SO THAT THE PROJECT DISPLAYS THE CURRENT
// FRAME ON SCREEN, AND RESETS THE # OF FRAMES
// WHENEVER A KEY IS PRESSED                                                     STOP
// GOOD LUCK                                                                     STOP

/**
 * 
 * This class will teach you how to integrate JavaFX into a project.
 * Based on Oracle's Hello World Project from http://docs.oracle.com/javase/8/javafx/get-started-tutorial/hello_world.htm
 * Note that if you create a new JavaFX project you need to make the following
 * edit to make it compile properly in Eclipse:
 * 1. Right click the project folder
 * 2. Select "Properties"
 * 3. Select "Java Build Path" from the properties window sidebar
 * 4. Select "Libraries" and expand the disclosure triangle for "JRE System Library"
 * 5. Double click "Access rules" and "Add" a new rule with "Resolution: Accessible"
 * and rule pattern "javafx/**" (no quotes when you enter it).
 * 
 * Otherwise, you can download the e(fx)clipse plugin.
 * 
 * JavaFX API Documentation: http://docs.oracle.com/javase/8/javafx/api/toc.htm
 * JavaFX Oracle Tutorials/Etc. http://docs.oracle.com/javase/8/javase-clienttechnologies.htm
 * @authors Patrick, Praveen
 *
 */
public class Main extends Application {
	
	private Canvas canvas; // This is the class that represents a canvas and its contents
	private GraphicsContext context; // This is the class that you call in order to draw on the screen
	private FrameTimer timer; // Repeatedly calls methods to simulate frames
	private KeyListener keyListener; // Listens to key presses and releases.
	private Image redBird = new Image("/redbird.png");
	
	public static void main(String[] args) {
        launch(args);
    }

	@Override
	// This is the setup method called on application launch.
	public void start(Stage stage) {
		
		canvas = new Canvas(800, 600); // Create the canvas
		context = canvas.getGraphicsContext2D(); // Store the context so that we can use it later

		Scene scene = new Scene(new Group(canvas)); // Create a "Scene" from the canvas.
		stage.setScene(scene);
		stage.show();
		
		timer = new FrameTimer(this); // The Timer manages the game loop: whenever it runs,
		// then the frame is updated.
		timer.start();
		keyListener = new KeyListener(this);
		scene.setOnKeyPressed(keyListener);
		
		/* 
		 * RECAP: We are given the Stage, which represents the physical window, such as dimensions and titles. 
		 * Scene represents the back end, where key listeners are attached and takes in a Group of objects.
		 * GraphicsContext is the painting mechanism of JavaFX
		 */
	}
	
	/**
	 * Called by the FrameTimer whenever it is time to draw a new frame (presumably about 30-60 times per second).
	 */
	public void renderFrame(){
		context.drawImage(redBird, Math.random()*400, Math.random()*400); // Draws the image redBird at a random position from (0,0) to (400,400)
		
		context.setFill(Color.BLACK); // You set the fill once and then all text / shapes drawn will have that fill color until you change it.
		// Fill color does not affect image drawing.
		
		context.fillText("How many frames have passed?", 500, 500);
		// The above method is used to draw text onto the canvas.
		// Note that the canvas is not automatically 'refreshed' at the end of a frame, since a frame is an artificial construct.
		// Any prior drawings remain and are 'painted over' by the next call to renderFrame unless it is cleared.
	}
	
	public void clearFrame(){
		context.clearRect(0, 0, 800, 600); // Clears a rectangle with left corner at (0,0), width 800, and height 600
	}
}
