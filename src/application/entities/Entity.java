package application.entities;

import application.Handler;
import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.GraphicsContext;

public abstract class Entity {
	
	protected Handler handler;
	protected double x, y;
	protected double width, height;
	protected Rectangle2D bounds;
	
	public Entity(Handler handler, float x, float y, int width, int height) {
		this.handler = handler;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		bounds = new Rectangle2D(0, 0, width, height);
		
	}
	
	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public Rectangle2D getBoundary(float xOffset, float yOffset) {
		return new Rectangle2D(x + bounds.getMinX() + xOffset, y + bounds.getMinY() + yOffset, width, height);
	}
	
	public boolean checkEntityCollision(float xOffset, float yOffset) {
		for(Entity e : handler.getWorld().getEntityManager().getEntities()) {
			if(e.equals(this)) {
				continue;
			}
			if(e.getBoundary(0f,0f).intersects(getBoundary(xOffset, yOffset))) {
				return true;
			}
		}
		return false;
	}
	
	//abstract function
	public abstract void update();
	
	public abstract void render(GraphicsContext gc);
	
	
}
