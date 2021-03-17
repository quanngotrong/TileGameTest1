package application.states;

import application.Handler;
import application.worlds.World;
import javafx.scene.canvas.GraphicsContext;

public class GameState extends State{
	
	private World world;
	
	public GameState(Handler handler) {
		 super(handler);
		 world = new World(handler, "res/maps/map1.txt");
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		world.update();
	}

	@Override
	public void render(GraphicsContext gc) {
		// TODO Auto-generated method stub
		world.render(gc);
	}
	
	
	
}
