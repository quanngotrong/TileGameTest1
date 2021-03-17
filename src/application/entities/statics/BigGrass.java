package application.entities.statics;

import application.Handler;
import application.gfx.Assets;
import application.tiles.Tile;
import javafx.scene.canvas.GraphicsContext;

public class BigGrass extends StaticEntity{

	public BigGrass(Handler handler, float x, float y) {
		super(handler, x, y, Tile.TILEWIDTH * 2, Tile.TILEHEIGHT * 2);
	}

	@Override
	public void update() {
		
	}

	@Override
	public void render(GraphicsContext gc) {
		gc.drawImage(Assets.bigGrass,
				x - handler.getGameCamera().getxOffset(), 
				y - handler.getGameCamera().getyOffset(),
				width,
				height);
	}
	
}
