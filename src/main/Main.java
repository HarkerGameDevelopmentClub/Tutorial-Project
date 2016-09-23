/**
 * Packages are like namespaces.
 */
package main;

import javafx.application.Application; // This is the root class for JavaFX Apps
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

// YOUR MISSION, SHOULD YOU CHOOSE TO ACCEPT IT STOP
// STUDY THE THREE CODE FILES IN THIS DEMO PROJECT
// AND EDIT IT SO THAT THE PROJECT DISPLAYS THE CURRENT
// FRAME ON SCREEN, AND RESETS THE # OF FRAMES
// WHENEVER A KEY IS PRESSED STOP
// GOOD LUCK STOP

/**
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
 * JavaFX API Documentation: http://docs.oracle.com/javase/8/javafx/api/toc.htm
 * JavaFX Oracle Tutorials/Etc. http://docs.oracle.com/javase/8/javase-clienttechnologies.htm
 * @author Praveen
 *
 */
public class Main extends Application {
	
	private Canvas canvas; // This is the class that has the canvas and canvas size
	private GraphicsContext context; // This is the class that you call in order to draw on the screen
	private FrameTimer timer; // Used to have a new frame be drawn many times a second
	private KeyListener keyListener; // Used to react to key presses
	private Image redBird = new Image("/redbird.png");
	
	/**
	 * I got this from the Hello World tutorial and I have no idea what it does
	 * but it must be important.
	 * @param args
	 */
	 public static void main(String[] args) {
	        launch(args);
	    }

	@Override
	/**
	 * This is the actual setup method called on app launch.
	 * The primaryStage is the app window we can use to display stuff.
	 */
	public void start(Stage stage) {
		
		canvas = new Canvas(800, 600); // Create the canvas
		context = canvas.getGraphicsContext2D(); // Store the context so that we can use it later

		Scene scene = new Scene(new Group(canvas)); // Create a "Scene" from the canvas.
		stage.setScene(scene);
		stage.show();
		// RECAP: We are given the Stage. We give the Stage a Scene that has a Group that has a Canvas that has a Context . . . 
		// No I don't know what much of this does
		// but I think that it is mostly relevant only if we want to
		// use the UI library (buttons and stuff). Since we are just
		// drawing every frame manually through the graphics context,
		// we don't need to do much with all of that.
		timer = new FrameTimer(this); // The Timer manages the game loop: whenever it runs,
		// then the frame is updated.
		timer.start();
		keyListener = new KeyListener(this);
		scene.setOnKeyPressed(keyListener);
	}
	
	/**
	 * Called whenever it is time to draw a new frame (presumably about 30-60 times per second).
	 */
	public void renderFrame()
	{
		context.drawImage(redBird, Math.random()*400, Math.random()*400);
		context.setFill(Color.BLACK); // You set the fill once and then all text / shapes
		// drawn will have that fill color until you change it.
		// does not affect images as far as I am aware
		context.fillText("How many frames have passed?", 500, 500);
		// The above method is the primary one used to draw onto the canvas.
		// Note that the canvas is not automaticaly 'refreshed' at the end of a frame.
		// Any prior drawings remain and are 'painted over' by the new frame.
		// You need to draw a background image / rectangle over the entire canvas
		// to "clear" the frame each time.
	}
	
	public void clearFrame()
	{
		context.setFill(Color.WHITE);
		context.fillRect(0, 0, 1000, 1000);
	}
}
