package application.states;

import application.Handler;
import javafx.scene.canvas.GraphicsContext;

public abstract class State {
	
	private static State currentState = null;
	
	public static void setState(State state) {
		currentState = state;
	}
	
	public static State getState() {
		return currentState;
	}
	
	//class
	protected Handler handler;
	
	public State(Handler handler) {
		this.handler = handler;
	}
	
	public abstract void update();
	
	public abstract void render(GraphicsContext gc);
	
}
