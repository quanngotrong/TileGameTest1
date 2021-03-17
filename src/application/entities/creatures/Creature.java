package application.entities.creatures;

import application.Handler;
import application.entities.Entity;
import application.tiles.Tile;
import javafx.scene.canvas.GraphicsContext;

public class Creature extends Entity{
	
	public static final int DEFAULT_HEALTH = 10;
	public static final float DEFAULT_SPEED = 3.0f;
	public static final int DEFAULT_CREATURE_WIDTH = 48,
			DEFAULT_CREATURE_HEIGHT = 64;
	
	protected int health;
	protected float speed;
	protected float xMove, yMove;
	
	public Creature(Handler handler, float x, float y, int width, int height) {
		super(handler, x, y, width, height);
		health = DEFAULT_HEALTH; 
		speed = DEFAULT_SPEED;
		xMove = 0;
		yMove = 0;
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(GraphicsContext gc) {
		// TODO Auto-generated method stub
		
	}
	
	public void move() {
		if(!checkEntityCollision(xMove, 0f)) {
			moveX();
		}
		if(!checkEntityCollision(0f, yMove)) {
			moveY();
		}
	}
	
	public void moveX() {
		if(xMove > 0) {//right
			int tx = (int) (x + xMove + bounds.getMinX() + bounds.getWidth())/ Tile.TILEWIDTH;
			if(!collisionWithTile(tx, (int) (y + bounds.getMinY())/Tile.TILEHEIGHT) &&
					!collisionWithTile(tx, (int) (y + bounds.getMinY() + bounds.getHeight())/Tile.TILEHEIGHT)) {
				x += xMove;
			}else {
				x = tx * Tile.TILEWIDTH - bounds.getMinX() - bounds.getWidth() -1;
			}
		}else if(xMove < 0) {//left
			int tx = (int) (x + xMove + bounds.getMinX())/ Tile.TILEWIDTH;
			if(!collisionWithTile(tx, (int) (y + bounds.getMinY())/Tile.TILEHEIGHT) &&
					!collisionWithTile(tx, (int) (y + bounds.getMinY() + bounds.getHeight())/Tile.TILEHEIGHT)) {
				x += xMove;
			}else {
				x = (tx+1) * Tile.TILEWIDTH -bounds.getMinX()+ 1;		
			}
		}
	}
	
	public void moveY() {
		if(yMove < 0) {//up
			int ty = (int) (y + yMove + bounds.getMinY()) / Tile.TILEHEIGHT;
			
			if(!collisionWithTile((int) (x + bounds.getMinX())/Tile.TILEWIDTH,ty) &&
					!collisionWithTile((int) (x + bounds.getMinX() + bounds.getWidth())/Tile.TILEWIDTH, ty)) {
				y += yMove;
			}else {
				y= ty * Tile.TILEHEIGHT + Tile.TILEHEIGHT - bounds.getMinY();
			}
		}else if(yMove > 0) {//down
			int ty = (int) (y + yMove + bounds.getMinY() + bounds.getHeight()) /Tile.TILEHEIGHT;
			
			if(!collisionWithTile((int) (x + bounds.getMinX())/Tile.TILEWIDTH,ty) &&
					!collisionWithTile((int) (x + bounds.getMinX() + bounds.getWidth())/Tile.TILEWIDTH,ty)) {
				y += yMove;
			}else {
				y = ty * Tile.TILEHEIGHT - bounds.getMinY()- bounds.getHeight() -1;
			}
		}
		
	}
	
	protected boolean collisionWithTile(int x, int y) {
		return handler.getWorld().getTile(x, y).isSolid();
	}
	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public float getSpeed() {
		return speed;
	}

	public void setSpeed(float speed) {
		this.speed = speed;
	}

	public float getxMove() {
		return xMove;
	}

	public void setxMove(float xMove) {
		this.xMove = xMove;
	}

	public float getyMove() {
		return yMove;
	}

	public void setyMove(float yMove) {
		this.yMove = yMove;
	}

}
