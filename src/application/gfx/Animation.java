package application.gfx;

import javafx.scene.image.Image;

public class Animation {
	private int speed, index;
	private long lastTime, timer;
	private Image[] frames;
	
	public Animation(int speed, Image[] frames) {
		this.speed = speed;
		this.frames = frames; 
		index = 0;
		timer = 0;
		lastTime = System.currentTimeMillis();
	}
	
	public void update() {
		timer += System.currentTimeMillis() - lastTime;
		lastTime = System.currentTimeMillis();
		
		if(timer > speed) {
			index = (index + 1)%frames.length;
			timer = 0; 
		}
	}
	
	public Image getCurrentFrame() {
		return frames[index];
	}
	
}
