package main;

import javafx.animation.AnimationTimer;

public class FrameTimer extends AnimationTimer {
	
	private Main main;
	
	public FrameTimer(Main main)
	{
		this.main = main;
	}

	@Override
	/**
	 * This is where the renderFrame is called every frame
	 */
	public void handle(long now) {
		main.renderFrame();
	}
}
