package application.gfx;

import application.Handler;
import application.tiles.Tile;

public class GameCamera {
	
	private Handler handler;
	private float xOffset, yOffset;
	
	public GameCamera(Handler handler, float xOffset, float yOffset) {
		this.handler = handler;
		this.xOffset = xOffset;
		this.yOffset = yOffset; 
	}
	
	public void checkBlankSpace() {
		if(xOffset < 0) {
			xOffset = 0;
		}else if(xOffset > handler.getWorld().getCol() * Tile.TILEWIDTH - handler.getWidth()) {
			xOffset = handler.getWorld().getCol() * Tile.TILEWIDTH - handler.getWidth();
		}
		
		if(xOffset < 0) {
			xOffset = 0;
		}else if(xOffset > handler.getWorld().getCol() * Tile.TILEWIDTH - handler.getWidth()) {
			xOffset = handler.getWorld().getCol() * Tile.TILEWIDTH - handler.getWidth();
		}
	}

	public float getxOffset() {
		return xOffset;
	}

	public void setxOffset(float xOffset) {
		this.xOffset = xOffset;
	}

	public float getyOffset() {
		return yOffset;
	}

	public void setyOffset(float yOffset) {
		this.yOffset = yOffset;
	}
}
