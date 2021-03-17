package application.worlds;

import application.Handler;
import application.entities.EntityManager;
import application.entities.creatures.Player;
import application.entities.statics.BigGrass;
import application.tiles.Tile;
import application.utils.Utils;
import javafx.scene.canvas.GraphicsContext;

public class World {
	
	private Handler handler;
	
	//number of col and row
	private int col, row;
	

	//start position of player
	private int spawnX, spawnY;
	private int[][] tiles;
	
	//Entities
	private EntityManager entityManager;
	
	public World(Handler handler, String path) {
		this.handler = handler;
		entityManager = new EntityManager(handler, new Player(handler, 100, 100));
		entityManager.addEntity(new BigGrass(handler, 0,0));

		loadWorld(path);
		
	}
	
	public void render(GraphicsContext gc) {
		int xStart = (int)Math.max(0, handler.getGameCamera().getxOffset() / Tile.TILEWIDTH);
		int xEnd = (int) Math.min(col, (handler.getGameCamera().getxOffset() + handler.getWidth())/Tile.TILEWIDTH + 1);
		int yStart = (int)Math.max(0, handler.getGameCamera().getyOffset() / Tile.TILEHEIGHT);
		int yEnd = (int) Math.min(row, (handler.getGameCamera().getyOffset() + handler.getHeight())/Tile.TILEHEIGHT + 1);
		
		for(int y = yStart ; y < yEnd ; y++) {
			for(int x = xStart; x < xEnd; x++) {
				getTile(x, y).render(
						gc,
						(int)(x * Tile.TILEWIDTH - handler.getGameCamera().getxOffset()),
						(int)(y * Tile.TILEHEIGHT- handler.getGameCamera().getyOffset()));
			}
		}
		
		entityManager.render(gc);
	}
	
	public void update() {
//		entityManager.update();
	}
	
	public Tile getTile(int x, int y) {
		if(x < 0 || y < 0 || x >= col || y>= row) {
			return Tile.grassTile;
		}
		
		Tile t = Tile.tiles[tiles[x][y]];
		if(t == null) {
			return Tile.grassTile;
		}
		return t;
	}
	
	private void loadWorld(String path) {
		String file = Utils.loadFileAsString(path);
		String[] tokens = file.split("\\s+");
		
		col = Utils.parseInt(tokens[0]);
		row = Utils.parseInt(tokens[1]);
		spawnX = Utils.parseInt(tokens[2]);
		spawnY = Utils.parseInt(tokens[3]);
		
		tiles = new int[col][row];
		for(int y = 0; y < row; y++) {
			for(int x =  0; x < col; x++) {
				tiles[x][y] = Utils.parseInt(tokens[(x+y*col) + 4]);
			}
		}
	}

	public int getCol() {
		return col;
	}

	public void setCol(int col) {
		this.col = col;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
}
