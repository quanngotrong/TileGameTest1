package application.entities.creatures;

import application.Handler;
import application.gfx.Animation;
import application.gfx.Assets;
import application.gfx.GameCamera;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Player extends Creature{
	
	private Animation animDown, animUp, animLeft, animRight;
	
	
	public Player(Handler handler, float x, float y) {
		super(handler, x, y, 48, 64);
		
		//Animations
		animDown = new Animation(500, Assets.player_down);
		animUp = new Animation(500, Assets.player_up);
		animLeft = new Animation(500, Assets.player_left);
		animRight = new Animation(500, Assets.player_right);
	}
	
	public void update() {
		//Animation
		animDown.update();
		animUp.update();
		animLeft.update();
		animRight.update();
		
		//Movement
		getInput();
		move();
	}
	
	private void getInput() {
		xMove = 0;
		yMove = 0;
		if(handler.getKeyManager().isDown()) {
			yMove = speed;
		}
		if(handler.getKeyManager().isUp()) {
			yMove = -speed;
		}
		if(handler.getKeyManager().isRight()) {
			xMove = speed;
		}
		if(handler.getKeyManager().isLeft()) {
			yMove = -speed;
		}
	}
	
	
	
	public void render(GraphicsContext gc) {
		gc.drawImage(getCurrentAnimationFrame(), (int)(x - handler.getGameCamera().getxOffset()),
				(int)(y - handler.getGameCamera().getyOffset()),
				width,
				height);
	}

	private Image getCurrentAnimationFrame() {
		
		if(xMove < 0) {
			return animLeft.getCurrentFrame();
		}
		else if(xMove > 0) {
			return animRight.getCurrentFrame();
		}
		else if(xMove < 0) {
			return animLeft.getCurrentFrame();
		}
		else if(xMove < 0) {
			return animLeft.getCurrentFrame();
		}
		
		return Assets.player_stand_down;
	}

}
