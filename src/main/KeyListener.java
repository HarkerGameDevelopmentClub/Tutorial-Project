package main;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;

/**
 * Listens for mouse clicks
 * @author Praveen
 *
 */
public class KeyListener implements EventHandler<KeyEvent> {
	
	private Main main;
	
	public KeyListener(Main main)
	{
		this.main = main;
	}
	
	@Override
	public void handle(KeyEvent event) {
		main.clearFrame();
	}

}
