package application.entities.statics;

import application.Handler;
import application.entities.Entity;
import javafx.scene.canvas.GraphicsContext;

public abstract class StaticEntity extends Entity{

	public StaticEntity(Handler handler, float x, float y, int width, int height) {
		super(handler, x, y, width, height);
	}

	
	
}
