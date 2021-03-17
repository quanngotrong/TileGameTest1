package application.settings;

import application.Game;
import application.Handler;

public class Setting {
	
	private Handler handler;
	private Game game;
	private int width,height;
	
	
	//fps
	private int fps;
	
	public Setting(Handler handler) {
		this.handler = handler;
		this.game = handler.getGame();
		
		//fps
		fps = 60;
		
		//size game
		width = 720;
		height = 720;
		
	}

	public int getFps() {
		return fps;
	}

	public void setFps(int fps) {
		this.fps = fps;
	}
	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

}
