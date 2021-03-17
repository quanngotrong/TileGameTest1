package application.input;

import java.util.ArrayList;
import java.util.EventListener;

import application.Handler;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;

public class KeyManager{
	
	private boolean up, down, left, right;
	private ArrayList<String> input;
	private Handler handler;
	
	public KeyManager(Handler handler) {
		this.handler = handler;
		input = new ArrayList<String>();
		
		up = false;
		down = false;
		left = false;
		right = false;
	}

	public void sceneKeyEvent(Scene scene) {
		scene.setOnKeyPressed(
			new EventHandler<KeyEvent>() {

				@Override
				public void handle(KeyEvent e) {
					String code = e.getCode().toString();
					
					if(!input.contains(code))
						input.add(code);
					
				}
				
			}
		);
		
		scene.setOnKeyReleased(
			new EventHandler<KeyEvent>() {

				@Override
				public void handle(KeyEvent e) {
					String code = e.getCode().toString();
					input.remove(code);
				}
			
			}
		);
		
	}
	
	public void update() {
		if(input.contains("W")) {
			up = true;
		}else up = false;
		if(input.contains("A")) {
			left = true;
		}else left = false;
		if(input.contains("D")) {
			right = true;
		}else right = false;
		if(input.contains("S")) {
			down = true;
		}else down = false;
	}
	
	public boolean isUp() {
		return up;
	}

	public void setUp(boolean up) {
		this.up = up;
	}

	public boolean isDown() {
		return down;
	}

	public void setDown(boolean down) {
		this.down = down;
	}

	public boolean isLeft() {
		return left;
	}

	public void setLeft(boolean left) {
		this.left = left;
	}

	public boolean isRight() {
		return right;
	}

	public void setRight(boolean right) {
		this.right = right;
	}

	public ArrayList<String> getInput() {
		return input;
	}

	public void setInput(ArrayList<String> input) {
		this.input = input;
	}
}
