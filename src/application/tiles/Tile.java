package application.tiles;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Tile {
	
	public static Tile[] tiles = new Tile[256];
	public static GrassTile grassTile = new GrassTile(0);
	
	//class
	public static final int TILEWIDTH = 36, TILEHEIGHT = 36;
	
	protected Image texture;
	protected final int id;
	
	public Tile(Image texture, int id) {
		this.texture = texture;
		this.id = id;
		
		tiles[id] = this;
	}
	
	public void render(GraphicsContext gc, int x, int y) {
		gc.drawImage(texture, x, y, TILEWIDTH, TILEHEIGHT);
	}
	
	public int getId() {
		return id;
	}

	public boolean isSolid() {
		// TODO Auto-generated method stub
		return false;
	}
}
